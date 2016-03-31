package by.tut.tiomkin.homework2;

import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "my_log";
    File file;
    ArrayList<Object> peopleList;
    private Button button;
    TextView idView, nameView, surnameView, ageView, isDegreeView, text;
    //private ProgressBar mProgressBar;
    View table;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //mProgressBar = (ProgressBar) findViewById(R.id.pb_progress);
        text = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button);
        idView = (TextView) findViewById(R.id.num);
        nameView = (TextView) findViewById(R.id.name);
        surnameView = (TextView) findViewById(R.id.surname);
        ageView = (TextView) findViewById(R.id.age);
        isDegreeView = (TextView) findViewById(R.id.degree);
        table = (View) findViewById(R.id.table);
        //file = new File("D:\\YandexDisk\\AndroidProjects\\HomeWork2\\app\\src\\main\\assets\\test.json");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //new ParseTask().execute();
                startThread();
            }
        });
    }

    private void startThread() {
        /*Thread thread = new Thread(runnable);
        thread.start();*/
        MyAsyncTask asyncTask = new MyAsyncTask();
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "hello", "world");
    }

    /*private Runnable runnable = new Runnable() {
        @Override
        public void run() {

            //Thread.sleep(2000);
            //здесь парсим
            File file = new File("D:\\YandexDisk\\AndroidProjects\\CourseAndroid\\app\\src\\main\\assets\\test.json");
            JSONParser parser = new JSONParser();

            Object obj = null;
            try {
                obj = parser.parse(new FileReader(file));
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray people = null;
            if (jsonObject != null) {
                people = (JSONArray) jsonObject.get("people");
            }

            peopleList = new ArrayList();

            if (people != null) {
                for (Object s : people) {
                    peopleList.add(s);
                }
            }

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //пишем всё, что нужно изменить в UI. результат парсинга передаем здесь
                    text.setText("Hello");
                }
            });
        }
    };*/

    private class MyAsyncTask extends AsyncTask<String, Void, String> {

        String resultJson;

        @Override
        protected String doInBackground(String... params) {
            //всё, что тут будет, будет выполнено в отдельном потоке
            //File file = new File("D:\\YandexDisk\\AndroidProjects\\CourseAndroid\\app\\src\\main\\assets\\test.json");

            try {

                AssetManager assetManager = MainActivity.this.getAssets();

                InputStream inputStream = assetManager.open("test.json");
                StringBuilder stringBuffer = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;

                while ((line = reader.readLine()) != null) {
                    stringBuffer.append(line);
                }

                resultJson = stringBuffer.toString();
                inputStream.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

            return resultJson;
        }


        @Override
        protected void onPostExecute(String s) {
            //super.onPostExecute(s);
            //выполняется в UI потоке после завершения doInBackground()
            //и сюда получим результат работы метода doInBackground()

            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray people = (JSONArray) jsonObject.get("people");
                JSONObject second = people.getJSONObject(1);
                String id = second.optString("id");
                String name = second.optString("name");
                String surname = second.optString("surname");
                String age = second.optString("age");
                String degree = second.optString("isDegree");
                idView.setText(id);
                nameView.setText(name);
                surnameView.setText(surname);
                ageView.setText(age);
                isDegreeView.setText(degree);
                table.setVisibility(View.VISIBLE);

            } catch (JSONException e) {
                e.printStackTrace();
            }


        }
    }

}

