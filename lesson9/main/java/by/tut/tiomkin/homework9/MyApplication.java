package by.tut.tiomkin.homework9;

import android.app.Application;
import android.util.Log;

import com.facebook.stetho.Stetho;

public class MyApplication  extends Application{

    private static MyApplication myApplication;

    public MyApplication getInstance() {
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
        myApplication = this;
        Log.d("MyApplication", "onCreate()");

    }
}
