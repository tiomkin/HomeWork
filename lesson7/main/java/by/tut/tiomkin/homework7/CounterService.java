package by.tut.tiomkin.homework7;


import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CounterService extends Service {

    protected static final String TAG = "CounterService";
    private final IBinder mIBinder = new LocalBinder();
    ExecutorService ex;


    public class LocalBinder extends Binder {
        CounterService getService() {
            return CounterService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind()");
        return mIBinder;
    }

    @Override
    public void onCreate() {
        Log.d(TAG, "onCreate()");
        super.onCreate();
        ex = Executors.newFixedThreadPool(1);


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.d(TAG, "onStartCommand()");

        ex.execute(new Counter());

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy()");
        super.onDestroy();
    }

    class Counter implements Runnable {

        @Override
        public void run() {
            Log.d(TAG, "Counter : run()");
            Intent myintent = new Intent(MainActivity.ACTION_MY);
            String key = "key";
            for (int i = 0; i < 100; i++) {

                try {
                    Thread.sleep(1000);
                    myintent.putExtra(key, i);
                    sendBroadcast(myintent);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


}
