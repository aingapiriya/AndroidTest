package com.codemobiles.cmmvptest.main;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.codemobiles.cmmvptest.R;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter mMainPresenter;

    // User Interface
    private EditText mUsernameEdittext;
    private EditText mPasswordEdittext;
    private Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindWidgets();
        setEvents();
        init();
    }

    private void init() {
        mMainPresenter = new MainPresenter(this);
    }

    /**
     * Call this method to bind widgets object from xml layout
     */
    private void bindWidgets() {
        mUsernameEdittext = findViewById(R.id.username_editText);
        mPasswordEdittext = findViewById(R.id.password_editText);
        mLoginButton = findViewById(R.id.login_button);
    }

    /**
     * Call this method to set all event listeners as needed to widgets
     */
    private void setEvents() {
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _username = mUsernameEdittext.getText().toString();
                String _password = mPasswordEdittext.getText().toString();

                mMainPresenter.isLoginSuccess(_username, _password);
            }
        });
    }

    @Override
    public void showErrorMessageMaxLogin() {
        Snackbar.make(mLoginButton, "Error! Login max limit", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoginInCorrect() {
        Snackbar.make(mLoginButton, "Username or Password Incorrect", Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoginSuccessMessage() {
        Snackbar.make(mLoginButton, "Login Success", Snackbar.LENGTH_LONG).show();
    }
}
