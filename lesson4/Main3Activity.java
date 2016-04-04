package by.tut.tiomkin.class4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main3Activity extends Activity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_3);
        mListView = (ListView) findViewById(R.id.my_list);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Item 1");
        arrayList.add("Item 2");
        arrayList.add("Item 3");
        arrayList.add("Item 1");
        arrayList.add("Item 1");
        arrayList.add("Item 1");
        arrayList.add("Item 1");
        arrayList.add("Item 1");
        arrayList.add("Item 1");
        arrayList.add("Item 1");
        arrayList.add("Item 1");
        arrayList.add("Item 1");
        arrayList.add("Item 1");
        arrayList.add("Item 1");

        ListAdapter listAdapter = new ListAdapter(this, arrayList);
        mListView.setAdapter(listAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(Main3Activity.this, "Hello", Toast.LENGTH_SHORT).show();

            }
        });





    }
}
