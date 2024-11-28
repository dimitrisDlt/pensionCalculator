#include "loginpagecontroller.h"
#include <iostream>

LoginPageController::LoginPageController(QObject *parent)
{

}

void LoginPageController::onLoginButtonClicked(QString attemptedPassword)
{
    password = "8989";
    if(password == attemptedPassword)
    {
        isPasswordCorrect = true;
         std::cout << "Right" << std::endl;
    }
    else
    {
        isPasswordCorrect = false;
        std::cout << "Wrong" << std::endl;

    }


}
