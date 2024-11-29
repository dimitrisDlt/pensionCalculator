#include "loginpagecontroller.h"
#include <iostream>

LoginPageController::LoginPageController(QObject *parent)
{
    setReadyToContinue(false);
}

void LoginPageController::onLoginButtonClicked(QString attemptedPassword)
{
    password = "8989";

    if(password == attemptedPassword)
    {
        isPasswordCorrect = true;
         std::cout << "Right" << std::endl;
        setReadyToContinue(true);
    }
    else
    {
        isPasswordCorrect = false;
        std::cout << "Wrong" << std::endl;

    }
}

bool LoginPageController::readyToContinue()
{
    return m_readyToContinue;
}

void LoginPageController::setReadyToContinue(bool isReady)
{
    if(m_readyToContinue == isReady)
    {
        return;
    }

    m_readyToContinue = isReady;

    if(m_readyToContinue == true)
    {
        emit readyToContinueChanged();
    }
}
