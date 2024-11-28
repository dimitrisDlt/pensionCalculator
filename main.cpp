#include <QGuiApplication>
#include <QQmlApplicationEngine>
#include <QQmlContext>
#include "loginpagecontroller.h"

int main(int argc, char *argv[])
{
    QGuiApplication app(argc, argv);

    QQmlApplicationEngine engine;
    LoginPageController *loginPageController = new LoginPageController(&app);
    engine.rootContext()->setContextProperty("centralController", loginPageController);

    QObject::connect(
        &engine,
        &QQmlApplicationEngine::objectCreationFailed,
        &app,
        []() { QCoreApplication::exit(-1); },
        Qt::QueuedConnection);
    engine.loadFromModule("pensionCalculator", "Main");

    return app.exec();
}
