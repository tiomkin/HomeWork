package by.tut.tiomkin.homework16_app2;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    static final Uri CONTENT_URL = Uri.parse("content://by.tut.tiomkin.homework16_app1.MyContentProvider/mycontentprovider");
    TextView contactsTextView = null;
    EditText idLookupEditText;
    Button mFind, mShow;

    ContentResolver resolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resolver = getContentResolver();

        contactsTextView = (TextView) findViewById(R.id.contactsTextView);
        idLookupEditText = (EditText) findViewById(R.id.idLookupEditText);
        mShow = (Button) findViewById(R.id.btnRetrieve);
        mFind = (Button) findViewById(R.id.findContactButton);
        mShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showContacts();
            }
        });
        mFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookupContact();
            }
        });

        getContacts();
    }

    public void getContacts(){

        String[] projection = new String[]{"id", "name"};

        Cursor cursor = resolver.query(CONTENT_URL, projection, null, null, null);

        String contactList = "";

        if(cursor.moveToFirst()){

            do{

                String id = cursor.getString(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));

                contactList = contactList + id + " : " + name + "\n";

            }while (cursor.moveToNext());

        }

        contactsTextView.setText(contactList);

    }

    public void lookupContact() {

        String idToFind = idLookupEditText.getText().toString();

        String[] projection = new String[]{"id", "name"};


        Cursor cursor = resolver.query(CONTENT_URL,
                projection, "id = ? ", new String[]{idToFind}, null);

        String contact = "";

        if(cursor.moveToFirst()){

            String id = cursor.getString(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));

            contact = contact + id + " : " + name + "\n";

        } else {

            Toast.makeText(this, "Пользователь не найден", Toast.LENGTH_SHORT).show();

        }

        contactsTextView.setText(contact);

    }

    public void showContacts() {

        getContacts();

    }

}
