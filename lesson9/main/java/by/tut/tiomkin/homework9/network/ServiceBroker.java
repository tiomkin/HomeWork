package by.tut.tiomkin.homework9.network;


import android.util.Log;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import by.tut.tiomkin.homework9.constants.Constants;
import by.tut.tiomkin.homework9.models.LoginRequest;
import by.tut.tiomkin.homework9.models.RegisterRequest;
import by.tut.tiomkin.homework9.network.api.IBaasApi;
import by.tut.tiomkin.homework9.network.deserializer.DateDeserializer;
import by.tut.tiomkin.homework9.network.interceptors.HttpLoggingInterceptor;
import by.tut.tiomkin.homework9.network.listeners.LoginCallback;
import by.tut.tiomkin.homework9.models.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Date;

import by.tut.tiomkin.homework9.network.listeners.RegisterCallback;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBroker {

    private static final String TAG = ServiceBroker.class.getSimpleName();

    private static ServiceBroker ourInstance = new ServiceBroker();
    private Retrofit mRetrofit;

    public static ServiceBroker getInstance() {
        return ourInstance;
    }

    public Retrofit getRetrofit() {

        if(mRetrofit == null) {

            OkHttpClient httBuilder = new OkHttpClient.Builder()
                    .addNetworkInterceptor(new StethoInterceptor())
                    .addInterceptor(new HttpLoggingInterceptor())
                    .addInterceptor(new Interceptor() {
                        @Override
                        public okhttp3.Response intercept(Chain chain) throws IOException {

                            Request request = chain.request();
                            Headers.Builder builder = request.headers().newBuilder();
                            builder.add("application-id", Constants.BAAS_REST_API_ID);
                            builder.add("secret-key", Constants.BAAS_REST_API_KEY);
                            builder.add("application-type", "REST");
                            builder.add("Content-Type", "application/json");

                            request = request.newBuilder().headers(builder.build()).build();
                            return chain.proceed(request);
                        }
                    })
                    .build();

            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
            Gson gson = gsonBuilder.create();

            mRetrofit = new Retrofit.Builder()
                    .baseUrl(Constants.API_URL)
                    .client(httBuilder)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return mRetrofit;
    }

    public void login(LoginRequest loginRequest, final LoginCallback callback) {

        IBaasApi baasApi = getRetrofit().create(IBaasApi.class);
        Call<Users> call = baasApi.login(loginRequest);

        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {

                Log.d(TAG, "onResponse()");

                Users user = response.body();

                if(response.isSuccessful() && user != null) {
                    //ВСЕ ОТЛИЧНО
                    Log.d(TAG, "all OK = " + user.toString());
                    callback.response(false);
                } else {
                    // ОШИБКА ЗАПРОСА
                    try {
                        Log.d(TAG, "error response code = " + response.code());
                        Log.d(TAG, "error response body = " + response.errorBody().string());
                    } catch (IOException e) {}
                    callback.response(true);
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                // ВСЕ СЛОМАЛСЬ - если нет интернета или что то закодили не правильно
                Log.d(TAG, "ERROR = " + t.toString());
                callback.response(true);
            }
        });
    }

    public void register(RegisterRequest registerRequest, final RegisterCallback callback) {

        IBaasApi baasApi = getRetrofit().create(IBaasApi.class);
        Call<Users> call = baasApi.register(registerRequest);

        call.enqueue(new Callback<Users>() {
            @Override
            public void onResponse(Call<Users> call, Response<Users> response) {

                Log.d(TAG, "onResponse()");

                Users user = response.body();

                if(response.isSuccessful() && user != null) {
                    //ВСЕ ОТЛИЧНО
                    Log.d(TAG, "all OK = " + user.toString());
                    callback.response(false);
                } else {
                    // ОШИБКА ЗАПРОСА
                    try {
                        Log.d(TAG, "error response code = " + response.code());
                        Log.d(TAG, "error response body = " + response.errorBody().string());
                    } catch (IOException e) {}
                    callback.response(true);
                }
            }

            @Override
            public void onFailure(Call<Users> call, Throwable t) {
                // ВСЕ СЛОМАЛСЬ - если нет интернета или что то закодили не правильно
                Log.d(TAG, "ERROR = " + t.toString());
                callback.response(true);
            }
        });
    }




}

