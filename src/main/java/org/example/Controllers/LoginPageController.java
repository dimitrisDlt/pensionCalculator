package org.example.Controllers;

import org.example.Views.LoginPageView;

public class LoginPageController
{
    public LoginPageView getLoginPageView()
    {
        return loginPageView;
    }

    public void setLoginPageView(LoginPageView loginPageView)
    {
        this.loginPageView = loginPageView;
    }

    private LoginPageView loginPageView;
}
