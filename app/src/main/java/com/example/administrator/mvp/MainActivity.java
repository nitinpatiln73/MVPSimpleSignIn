package com.example.administrator.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.mvp.model.SigninPresenterImpl;
import com.example.administrator.mvp.model.SigninPresenter_Impl;
import com.example.administrator.mvp.presenter.SignInPresenter;
import com.example.administrator.mvp.presenter.Signin_Presenter;
import com.example.administrator.mvp.view.SigninView;
import com.example.administrator.mvp.view.Signin_view;

public class MainActivity extends AppCompatActivity implements Signin_view {

    private Signin_Presenter signinPresenter_;
    EditText etUsername, etPassword;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signinPresenter_ = new SigninPresenter_Impl(MainActivity.this);
                signinPresenter_.signIn( etUsername.getText().toString(), etPassword.getText().toString());
            }
        });
//What to do
    }

    @Override
    public void signInError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void signInSuccess() {
        Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showValidationError() {
        Toast.makeText(this, "Validation Error", Toast.LENGTH_SHORT).show();
    }
}
