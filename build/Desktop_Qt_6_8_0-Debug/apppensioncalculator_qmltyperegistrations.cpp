/****************************************************************************
** Generated QML type registration code
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include <QtQml/qqml.h>
#include <QtQml/qqmlmoduleregistration.h>

#if __has_include(<centralcontroller.h>)
#  include <centralcontroller.h>
#endif
#if __has_include(<loginpagecontroller.h>)
#  include <loginpagecontroller.h>
#endif


#if !defined(QT_STATIC)
#define Q_QMLTYPE_EXPORT Q_DECL_EXPORT
#else
#define Q_QMLTYPE_EXPORT
#endif
Q_QMLTYPE_EXPORT void qml_register_types_pensionCalculator()
{
    QT_WARNING_PUSH QT_WARNING_DISABLE_DEPRECATED
    qmlRegisterTypesAndRevisions<CentralController>("pensionCalculator", 1);
    qmlRegisterTypesAndRevisions<LoginPageController>("pensionCalculator", 1);
    QT_WARNING_POP
    qmlRegisterModule("pensionCalculator", 1, 0);
}

static const QQmlModuleRegistration pensionCalculatorRegistration("pensionCalculator", qml_register_types_pensionCalculator);
