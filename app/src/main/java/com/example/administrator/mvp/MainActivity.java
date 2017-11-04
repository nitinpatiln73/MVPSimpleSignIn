package com.example.administrator.mvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.administrator.mvp.model.SigninPresenterImpl;
import com.example.administrator.mvp.presenter.SignInPresenter;
import com.example.administrator.mvp.view.SigninView;

public class MainActivity extends AppCompatActivity implements SigninView {

    private SignInPresenter signInPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Comments
        signInPresenter = new SigninPresenterImpl(this);
        signInPresenter.signIn("ni3", "pass");
    }

    @Override
    public void signInError() {
        Toast.makeText(this, "Wrong Password", Toast.LENGTH_SHORT).show();
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
