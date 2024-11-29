#ifndef LOGINPAGECONTROLLER_H
#define LOGINPAGECONTROLLER_H

#include <QObject>
#include <QQmlEngine>

class LoginPageController : public QObject
{
    Q_OBJECT
    QML_ELEMENT
    Q_PROPERTY(bool readyToContinue READ readyToContinue WRITE setReadyToContinue NOTIFY readyToContinueChanged)

public:
    explicit LoginPageController(QObject *parent = nullptr);
    void setReadyToContinue(bool isReady);
    bool readyToContinue();
public slots:
    void onLoginButtonClicked(QString attemptedPassword);

signals:
    void readyToContinueChanged();
private:
    QString password;
    bool isPasswordCorrect;
    bool m_readyToContinue;
};

#endif // LOGINPAGECONTROLLER_H
