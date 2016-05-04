package by.tut.tiomkin.class12;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main2Activity extends AppCompatActivity {

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mHandler = new Handler();

        //На onPause надо удалять handler. Поэтому лучше разнести старт и стоп в onResume и onPause
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Что-то запускается через 2 секунды
            }
        }, 2000);


    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            //
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        mHandler.postDelayed(runnable, 2000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mHandler.removeCallbacks(runnable);
    }
}
