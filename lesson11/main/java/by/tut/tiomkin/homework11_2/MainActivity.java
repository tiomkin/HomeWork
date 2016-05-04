package by.tut.tiomkin.homework11_2;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    private EditText idText;
    private EditText nameText;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);

        idText = (EditText) findViewById(R.id.id);
        nameText = (EditText) findViewById(R.id.name);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // тут будем делать сохранение в базу
                saveToDatababase();
                getFromDatababase();
            }
        });
    }

    private void saveToDatababase() {

        int id = Integer.valueOf(idText.getText().toString());
        dbHelper.save(id, String.valueOf(nameText.getText()));
    }

    private void getFromDatababase() {

        Log.d(TAG, "getFromDatabase()");

        ArrayList<User> users = dbHelper.getAllUsers();

        for (User e : users) {
            Log.d(TAG, "getFromDatabase() row: id =  " + e.getId()
            + " name = " + e.getName());
        }

    }
}

