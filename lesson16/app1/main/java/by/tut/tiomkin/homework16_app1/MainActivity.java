package by.tut.tiomkin.homework16_app1;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    EditText mName;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mName = (EditText) findViewById(R.id.et_name);
        mButton = (Button) findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addName();
            }
        });
    }

    public void addName() {
        String name = mName.getText().toString();
        ContentValues values = new ContentValues();
        values.put(MyContentProvider.name, name);

        Uri uri = getContentResolver().insert(MyContentProvider.CONTENT_URL, values);

        Toast.makeText(getBaseContext(), "Новый пользователь успешно добавлен", Toast.LENGTH_SHORT).show();
    }

}
