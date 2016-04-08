package by.tut.tiomkin.homework5;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    public RecyclerView mRecyclerView;


    public int spanCount = 2;


    public int imgQuantity = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);

        mRecyclerView.setHasFixedSize(true);


        GridLayoutManager manager = new GridLayoutManager(this, spanCount);
        mRecyclerView.setLayoutManager(manager);

        MyRecyclerAdapter adapter = new MyRecyclerAdapter(imgQuantity);
        mRecyclerView.setAdapter(adapter);
    }
}
