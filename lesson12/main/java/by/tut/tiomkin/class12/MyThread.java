package by.tut.tiomkin.class12;


import android.os.Handler;
import android.os.Message;

public class MyThread extends Thread {

    private Handler mHandler;

    public MyThread(Handler handler) {
        mHandler = handler;

    };

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Message msg = new Message();
        msg.what = Main3Activity.MESSAGE_TOAST;
        msg.arg1 = 500;
        msg.arg2 = 700;
        msg.obj = new String("Hi");

        mHandler.sendMessage(msg);

        //можно и просто так
        //mHandler.sendEmptyMessage(Main3Activity.MESSAGE_TOAST);
    }
}
