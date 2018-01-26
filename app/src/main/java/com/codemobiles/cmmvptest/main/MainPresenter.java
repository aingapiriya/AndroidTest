package com.codemobiles.cmmvptest.main;


public class MainPresenter {

    private final MainView mMainView;

    private int mCountErrorLogin = 0;
    private static final int MAX_ERROR_LOGIN = 3;

    public MainPresenter(MainView _mainView) {
        this.mMainView = _mainView;
    }

    public int countErrorLogin() {
        mCountErrorLogin++;
        return mCountErrorLogin;
    }

    private void resetCountError() {
        mCountErrorLogin = 0;
    }

    public boolean isMaxErrorLogin() {
        return mCountErrorLogin >= MAX_ERROR_LOGIN;
    }

    public boolean isLoginSuccess(String _username, String _password) {

        if (checkMinInput(_username,_password)){
            mMainView.showMinMessage();
            return false;
        }

        if (_username.equals("admin") && _password.equals("password")) {
            mMainView.showLoginSuccessMessage();
            resetCountError();
            return true;
        }

        if (isMaxErrorLogin()) {
            mMainView.showErrorMessageMaxLogin();
            return false;
        }

        countErrorLogin();
        mMainView.showLoginInCorrect();
        return false;
    }

    public boolean checkMinInput(String ad, String pass) {
        if (ad.length() >= 5 && pass.length() >= 5){return false;}
        return true;

    }
}
