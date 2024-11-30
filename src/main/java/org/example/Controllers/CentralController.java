package org.example.Controllers;

public class CentralController
{
    public LoginPageController getLoginPageController() {
        return loginPageController;
    }

    public void setLoginPageController(LoginPageController loginPageController) {
        this.loginPageController = loginPageController;
    }

    private LoginPageController loginPageController;

}
