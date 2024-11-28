#ifndef LOGINPAGECONTROLLER_H
#define LOGINPAGECONTROLLER_H

#include <QObject>
#include <QQmlEngine>

class LoginPageController : public QObject
{
    Q_OBJECT
    QML_ELEMENT

public:
    explicit LoginPageController(QObject *parent = nullptr);
protected slots:
    void onLoginButtonClicked(QString attemptedPassword);
private:
    QString password;
    bool isPasswordCorrect;
};

#endif // LOGINPAGECONTROLLER_H
