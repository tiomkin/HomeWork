package by.tut.tiomkin.homework9.network.api;

import by.tut.tiomkin.homework9.models.LoginRequest;
import by.tut.tiomkin.homework9.models.RegisterRequest;
import by.tut.tiomkin.homework9.models.Users;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface IBaasApi {

    @POST("v1/users/login")
    Call<Users> login(@Body LoginRequest loginRequest);

    @POST("v1/users/register")
    Call<Users> register(@Body RegisterRequest registerRequest);
}

