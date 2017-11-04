package com.example.administrator.mvp.model;

import android.text.TextUtils;

import com.example.administrator.mvp.presenter.SignInPresenter;
import com.example.administrator.mvp.view.SigninView;

/**
 * Created by Administrator on 04-11-2017.
 */

public class SigninPresenterImpl implements SignInPresenter {

    private SigninView signinView;

    public SigninPresenterImpl(SigninView signinView) {
        this.signinView = signinView;
    }

    @Override
    public void signIn(String userName, String password) {

        if (TextUtils.isEmpty( userName ) || TextUtils.isEmpty( password ) ){
            signinView.showValidationError();
        }
        else{
            if (userName.equalsIgnoreCase( "ni3") && password.equalsIgnoreCase( "pass" ) ){
                signinView.signInSuccess();
            }else{
                signinView.signInError();
            }
        }
    }
}
