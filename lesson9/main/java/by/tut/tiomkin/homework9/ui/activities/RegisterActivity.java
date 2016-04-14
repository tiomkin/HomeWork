package by.tut.tiomkin.homework9.ui.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import by.tut.tiomkin.homework9.R;
import by.tut.tiomkin.homework9.models.RegisterRequest;
import by.tut.tiomkin.homework9.network.ServiceBroker;
import by.tut.tiomkin.homework9.network.listeners.LoginCallback;
import by.tut.tiomkin.homework9.network.listeners.RegisterCallback;

public class RegisterActivity extends AppCompatActivity {

    EditText mEmail, mPassword, mPasswordAgain;
    Button mButton;
    ProgressBar mProgressBarRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEmail = (EditText) findViewById(R.id.reg_login);
        mPassword = (EditText) findViewById(R.id.reg_pass);
        mPasswordAgain = (EditText) findViewById(R.id.reg_pass_again);
        mButton = (Button) findViewById(R.id.reg_bt_register);
        mProgressBarRegister = (ProgressBar) findViewById(R.id.progressBarRegister);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pass1 = String.valueOf(mPassword.getText());
                String pass2 = String.valueOf(mPasswordAgain.getText());
                if (pass1.equals(pass2)) {
                    RegisterRequest registerRequest = new RegisterRequest(
                            String.valueOf(mEmail.getText()),
                            pass1
                    );

                    mProgressBarRegister.setVisibility(ProgressBar.VISIBLE);

                    ServiceBroker.getInstance().register(registerRequest, new RegisterCallback() {
                        @Override
                        public void response(boolean isError) {
                            // а тут остановить ProgressBar
                            mProgressBarRegister.setVisibility(ProgressBar.GONE);

                            if (isError) {
                                //mTextView.setText("Ошибка");
                                Toast.makeText(RegisterActivity.this, "ОШИБКА! Не удалось зарегистрироваться", Toast.LENGTH_SHORT).show();
                            } else {
                                //mTextView.setText("Все супер");

                                startActivity(new Intent(RegisterActivity.this, RegisteredActivity.class));
                            }
                        }
                    });

                } else {
                    Toast.makeText(RegisterActivity.this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
