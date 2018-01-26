package com.codemobiles.cmmvptest.main;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MainPresenterTest {


    @Test
    public void testCountErrorLogin(){
        MainView _mainView = mock(MainView.class);
        MainPresenter _mainPresenter = new MainPresenter(_mainView);

        assertEquals(1, _mainPresenter.countErrorLogin());
        assertEquals(2, _mainPresenter.countErrorLogin());
        assertEquals(3, _mainPresenter.countErrorLogin());
        assertTrue(_mainPresenter.isMaxErrorLogin());
    }

    @Test
    public void testNotMaxErrorLogin() {
        MainView _mainView = mock(MainView.class);
        MainPresenter _mainPresenter = new MainPresenter(_mainView);

        assertFalse(_mainPresenter.isMaxErrorLogin());
    }

    @Test
    public void testLoginSuccess(){
        MainView _mainView = mock(MainView.class);
        MainPresenter _mainPresenter = new MainPresenter(_mainView);

        assertTrue(_mainPresenter.isLoginSuccess("admin", "password"));
    }

    @Test
    public void testUsernamePasswordCorrentAndViewCalled(){
        MainView _mainView = mock(MainView.class);
        MainPresenter _mainPresenter = new MainPresenter(_mainView);

        _mainPresenter.isLoginSuccess("admin","password");
        verify(_mainView).showLoginSuccessMessage();
    }

    @Test
    public void testUsernamePasswordInCorrentAndViewCalled(){
        MainView _mainView = mock(MainView.class);
        MainPresenter _mainPresenter = new MainPresenter(_mainView);

        _mainPresenter.isLoginSuccess("codemobiles","test");
        verify(_mainView).showLoginInCorrect();
    }

    @Test
    public void testMaxLoginAndViewCalled(){
        MainView _mainView = mock(MainView.class);
        MainPresenter _mainPresenter = new MainPresenter(_mainView);

        _mainPresenter.isLoginSuccess("codemobiles","test");
        _mainPresenter.isLoginSuccess("codemobiles","test");
        _mainPresenter.isLoginSuccess("codemobiles","test");
        _mainPresenter.isLoginSuccess("codemobiles","test");
        verify(_mainView).showErrorMessageMaxLogin();
    }



}