package by.tut.tiomkin.homework9.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import by.tut.tiomkin.homework9.R;
import by.tut.tiomkin.homework9.models.LoginRequest;
import by.tut.tiomkin.homework9.network.listeners.LoginCallback;
import by.tut.tiomkin.homework9.network.ServiceBroker;

public class MainActivity extends Activity{

    private static final String TAG = MainActivity.class.getSimpleName();

    private EditText mLoginEditText;
    private EditText mPasswordEditText;
    private Button mButtonLogin, mButtonRegister;
    private TextView mTextView;
    private ProgressBar mPogressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonLogin = (Button) findViewById(R.id.bt_login);
        mButtonRegister = (Button) findViewById(R.id.bt_register);
        mTextView = (TextView) findViewById(R.id.tv_text);
        mLoginEditText = (EditText) findViewById(R.id.et_login);
        mPasswordEditText = (EditText) findViewById(R.id.et_password);
        mPogressBar = (ProgressBar) findViewById(R.id.progressBarLogin);

        //Отправляем на Backendless данные пользователя и если пользователь существует стартуем LogedInActivity по нажатию на кнопку Login
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                LoginRequest loginRequest = new LoginRequest(
                        String.valueOf(mLoginEditText.getText()),
                        String.valueOf(mPasswordEditText.getText()));

                // тут можно запустить ProgressBar
                mPogressBar.setVisibility(ProgressBar.VISIBLE);

                ServiceBroker.getInstance().login(loginRequest, new LoginCallback() {
                    @Override
                    public void response(boolean isError) {
                        // а тут остановить ProgressBar
                        mPogressBar.setVisibility(ProgressBar.GONE);
                        if (isError) {
                            //mTextView.setText("Ошибка");
                            Toast.makeText(MainActivity.this, "Проверьте логин или пароль", Toast.LENGTH_SHORT).show();
                        } else {
                            //mTextView.setText("Все супер");

                            startActivity(new Intent(MainActivity.this, LogedInActivity.class));
                        }
                    }
                });
            }
        });

        //Стартуем RegisterActivity, где пользователь введёт данные для регистрации
        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, RegisterActivity.class));

            }
        });
    }

}
