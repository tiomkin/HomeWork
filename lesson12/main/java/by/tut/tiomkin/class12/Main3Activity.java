package by.tut.tiomkin.class12;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    public static final int MESSAGE_TOAST = 0;
    public static final int MESSAGE_ALERT = 1;

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //mHandler = new Handler();


        //Вариант со своим Handler
        mHandler = new Myhandler();


        MyThread myThread = new MyThread(mHandler);
        myThread.start();


    }

    private class Myhandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MESSAGE_TOAST:
                    Toast.makeText(Main3Activity.this, "Toast", Toast.LENGTH_SHORT).show();
                    Log.d("Main3Activity", "msg.arg1 = " + msg.arg1);
                    Log.d("Main3Activity", "msg.arg2 = " + msg.arg2);
                    Log.d("Main3Activity", "msg.obj = " + ((String)msg.obj));
                    break;
                case MESSAGE_ALERT:
                    //здесь alert
                    break;
                default:
                    //Неизвестное сообщение

            }
        }
    }


}
