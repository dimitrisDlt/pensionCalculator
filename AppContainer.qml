import QtQuick
import QtQuick.Layouts

Rectangle
{
    anchors.fill: parent
    color: "transparent"

    StackLayout
    {
        property int newIndex: 0
        id: stack
        anchors.fill: parent

        currentIndex: 0

        LoginPage
        {

        }

        BasicChoicePage
        {

        }
    }

}
