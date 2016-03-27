package by.tut.tiomkin.myapplication;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends Activity implements View.OnClickListener {

    TextView text, text2;
    String s1, s2, temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "onCreate()");
        text = (TextView) findViewById(R.id.textView);
        text2 = (TextView) findViewById(R.id.textView2);
        s1 = (String) text.getText();
        s2 = (String) text2.getText();

        text.setOnClickListener(this);

        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                temp = s1;
                s1 = s2;
                s2 = temp;
                text.setText(s1);
                text2.setText(s2);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "onStart()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MainActivity", "onStop()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MainActivity", "onPause()");
    }

    @Override
    public void onClick(View v) {

        temp = s1;
        s1 = s2;
        s2 = temp;
        text.setText(s1);
        text2.setText(s2);
    }

    public void changeOrder(View view) {

        temp = s1;
        s1 = s2;
        s2 = temp;
        text.setText(s1);
        text2.setText(s2);

    }


}
