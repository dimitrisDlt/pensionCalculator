import QtQuick
import QtQuick.Controls

Window
{
    width: 1024
    height: 596
    visible: true
    title: qsTr("Pension Calculator")

    StackView
    {
        id: stack
        anchors.fill: parent

        LoginPage
        {

        }
    }
}
