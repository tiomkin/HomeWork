package by.tut.tiomkin.homework7;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    protected static final String TAG = "MainActivity";
    public static final String ACTION_MY = "by.tut.tiomkin.homework7.MainActivity.ACTION_MY";
    public static final int COUNT = 0;
    protected BroadcastReceiver receiver;

    Button mButtonStart, mButtonStop;
    TextView mTextView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButtonStart = (Button) findViewById(R.id.button_start);
        mButtonStop = (Button) findViewById(R.id.button_stop);
        mTextView = (TextView) findViewById(R.id.text);
        //intent = new Intent(MainActivity.this, CounterService.class);

        mButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, CounterService.class);
                startService(intent);

            }
        });

        mButtonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(new Intent(MainActivity.this, CounterService.class));
                unregisterReceiver(receiver);
                //mTextView.setText("0");
            }
        });


    }

    @Override
    protected void onResume() {
        Log.d(TAG, "onResume()");
        super.onResume();

        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                Log.d(TAG, "BroadcastReceiver : onReceive()");

                String action = intent.getAction();
                Bundle extras;
                int count;

                if (action.equals(ACTION_MY)) {

                    count = intent.getIntExtra("key", 0);

                    mTextView.setText(String.valueOf(count));
                }

            }


        };

        IntentFilter filter = new IntentFilter(ACTION_MY);
        //filter.addAction(ACTION_MY);
        //LocalBroadcastManager.getInstance(MainActivity.this).registerReceiver(receiver, filter);

        registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause()");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy()");
        super.onDestroy();
        //LocalBroadcastManager.getInstance(MainActivity.this).unregisterReceiver(receiver);
        //stopService(new Intent(MainActivity.this, CounterService.class));
        stopService(intent);
        unregisterReceiver(receiver);
    }

/*
    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d(TAG, "BroadcastReceiver : onReceive()");

            String action = intent.getAction();
            Bundle extras;
            int count;

            if (action.equals(ACTION_MY)) {
                extras = getIntent().getExtras();
                count = extras.getInt("key");
                mTextView.setText(count);
            }

        }


    };
*/


}
