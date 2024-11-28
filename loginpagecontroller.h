#ifndef LOGINPAGECONTROLLER_H
#define LOGINPAGECONTROLLER_H

#include <QObject>
#include <QQmlEngine>

class LoginPageController : public QObject
{
    Q_OBJECT
    QML_ELEMENT
public:
    LoginPageController();
protected slots:
    void onLoginButtonClicked();
};

#endif // LOGINPAGECONTROLLER_H
