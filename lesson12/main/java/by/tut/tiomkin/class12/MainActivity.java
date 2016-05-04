package by.tut.tiomkin.class12;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getMainLooper привязывает Handler к главному потоку
        //Если без getMainLooper, то будет выполняться там, где его запустили
        //mHandler = new Handler(Looper.getMainLooper());

        /*mHandler.post(new Runnable() {
            @Override
            public void run() {
                //что-то делаем в UI потоке
            }
        });*/

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Привязан к этому потоку
                mHandler = new Handler();

                //Поток стартанул и мы находимся в отдельном потоке

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //выполнится в UI потоке. Например, можем открыть диалог
                    }
                });
            }
        });
        thread.start();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //будет выполнено от имени первого потока
                    }
                });
            }
        });
    }
}
