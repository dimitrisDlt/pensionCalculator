/****************************************************************************
** Meta object code from reading C++ file 'loginpagecontroller.h'
**
** Created by: The Qt Meta Object Compiler version 68 (Qt 6.8.0)
**
** WARNING! All changes made in this file will be lost!
*****************************************************************************/

#include "../../../../loginpagecontroller.h"
#include <QtCore/qmetatype.h>

#include <QtCore/qtmochelpers.h>

#include <memory>


#include <QtCore/qxptype_traits.h>
#if !defined(Q_MOC_OUTPUT_REVISION)
#error "The header file 'loginpagecontroller.h' doesn't include <QObject>."
#elif Q_MOC_OUTPUT_REVISION != 68
#error "This file was generated using the moc from 6.8.0. It"
#error "cannot be used with the include files from this version of Qt."
#error "(The moc has changed too much.)"
#endif

#ifndef Q_CONSTINIT
#define Q_CONSTINIT
#endif

QT_WARNING_PUSH
QT_WARNING_DISABLE_DEPRECATED
QT_WARNING_DISABLE_GCC("-Wuseless-cast")
namespace {

#ifdef QT_MOC_HAS_STRINGDATA
struct qt_meta_stringdata_CLASSLoginPageControllerENDCLASS_t {};
constexpr auto qt_meta_stringdata_CLASSLoginPageControllerENDCLASS = QtMocHelpers::stringData(
    "LoginPageController",
    "QML.Element",
    "auto",
    "onLoginButtonClicked",
    "",
    "attemptedPassword"
);
#else  // !QT_MOC_HAS_STRINGDATA
#error "qtmochelpers.h not found or too old."
#endif // !QT_MOC_HAS_STRINGDATA
} // unnamed namespace

Q_CONSTINIT static const uint qt_meta_data_CLASSLoginPageControllerENDCLASS[] = {

 // content:
      12,       // revision
       0,       // classname
       1,   14, // classinfo
       1,   16, // methods
       0,    0, // properties
       0,    0, // enums/sets
       0,    0, // constructors
       0,       // flags
       0,       // signalCount

 // classinfo: key, value
       1,    2,

 // slots: name, argc, parameters, tag, flags, initial metatype offsets
       3,    1,   22,    4, 0x09,    1 /* Protected */,

 // slots: parameters
    QMetaType::Void, QMetaType::QString,    5,

       0        // eod
};

Q_CONSTINIT const QMetaObject LoginPageController::staticMetaObject = { {
    QMetaObject::SuperData::link<QObject::staticMetaObject>(),
    qt_meta_stringdata_CLASSLoginPageControllerENDCLASS.offsetsAndSizes,
    qt_meta_data_CLASSLoginPageControllerENDCLASS,
    qt_static_metacall,
    nullptr,
    qt_metaTypeArray<
        // Q_OBJECT / Q_GADGET
        LoginPageController,
        // method 'onLoginButtonClicked'
        void,
        QString
    >,
    nullptr
} };

void LoginPageController::qt_static_metacall(QObject *_o, QMetaObject::Call _c, int _id, void **_a)
{
    if (_c == QMetaObject::InvokeMetaMethod) {
        auto *_t = static_cast<LoginPageController *>(_o);
        (void)_t;
        switch (_id) {
        case 0: _t->onLoginButtonClicked((*reinterpret_cast< std::add_pointer_t<QString>>(_a[1]))); break;
        default: ;
        }
    }
}

const QMetaObject *LoginPageController::metaObject() const
{
    return QObject::d_ptr->metaObject ? QObject::d_ptr->dynamicMetaObject() : &staticMetaObject;
}

void *LoginPageController::qt_metacast(const char *_clname)
{
    if (!_clname) return nullptr;
    if (!strcmp(_clname, qt_meta_stringdata_CLASSLoginPageControllerENDCLASS.stringdata0))
        return static_cast<void*>(this);
    return QObject::qt_metacast(_clname);
}

int LoginPageController::qt_metacall(QMetaObject::Call _c, int _id, void **_a)
{
    _id = QObject::qt_metacall(_c, _id, _a);
    if (_id < 0)
        return _id;
    if (_c == QMetaObject::InvokeMetaMethod) {
        if (_id < 1)
            qt_static_metacall(this, _c, _id, _a);
        _id -= 1;
    } else if (_c == QMetaObject::RegisterMethodArgumentMetaType) {
        if (_id < 1)
            *reinterpret_cast<QMetaType *>(_a[0]) = QMetaType();
        _id -= 1;
    }
    return _id;
}
QT_WARNING_POP
