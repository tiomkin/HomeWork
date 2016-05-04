package by.tut.tiomkin.class12;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;

import java.util.HashMap;
import java.util.Map;

public class WithMyCircleDiagramActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_my_circle_diagram);

        HashMap<String, Integer> data = new HashMap<>();
        data.put("green", 11);
        data.put("RED", 120);
        data.put("YELLOW", 50);
        data.put("blue", 26);



        MyCircleDiagram diagram = (MyCircleDiagram) findViewById(R.id.myCircle);
        diagram.setData(data);
    }
}
