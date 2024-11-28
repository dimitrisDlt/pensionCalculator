#ifndef CENTRALCONTROLLER_H
#define CENTRALCONTROLLER_H

#include <QObject>
#include <QQmlEngine>
#include "loginpagecontroller.h"

class CentralController : public QObject
{
    Q_OBJECT
    QML_ELEMENT
public:
    CentralController();
protected:
    LoginPageController loginPageController;
};

#endif // CENTRALCONTROLLER_H
