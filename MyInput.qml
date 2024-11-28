import QtQuick
import QtQuick.Effects

Rectangle
{
    id: myInput
    property string source
    property color insideColor: "#E9EFEC"
    property color textColor: "#16423C"

    height: 40
    width: 200
    color: "#16423C"

    ParallelAnimation
    {
        id: parallerAnimation

        PropertyAnimation
        {
            id: animateTextColor
            target: myInput
            properties: "textColor"
            to: "white"
            duration: 500
        }

        PropertyAnimation
        {

            id: animateInsideBackgroundColor
            target: myInput
            properties: "insideColor"
            to: "#16423C"
            duration: 500
        }
    }

    ParallelAnimation
    {
        id: parallerAnimationExit

        PropertyAnimation
        {
            id: animateTextColorExit
            target: myInput
            properties: "textColor"
            to: "#16423C"
            duration: 500
        }

        PropertyAnimation
        {

            id: animateInsideBackgroundColorExit
            target: myInput
            properties: "insideColor"
            to: "#E9EFEC"
            duration: 500
        }
    }
    MouseArea
    {
        property string source: parent.source
        property color insideColor: parent.insideColor
        property color textColor: parent.textColor

        id: mouseArea
        anchors.fill: parent
        hoverEnabled: true

        onEntered:
        {
            parallerAnimation.start()
        }

        onExited:
        {
            parallerAnimationExit.start()
        }

        Rectangle
        {
            property string source: parent.source
            property color insideColor: parent.insideColor
            property color textColor: parent.textColor

            id: insideRect

            anchors
            {
                top: parent.top
                bottom: parent.bottom
                left: parent.left
                right: parent.right
                bottomMargin: 4
            }

            color: insideColor

            Image
            {
                property color imgColor: parent.textColor
                id: img
                anchors
                {
                    top: parent.top
                    bottom : parent.bottom
                    left: parent.left
                    margins: 5
                }

                source: parent.source
                width: 30
                visible: parent.source.length ? true : false

                MultiEffect
                {
                    anchors.fill: img
                    source: img
                    brightness: 1.0
                    colorization: 1.0
                    colorizationColor: img.imgColor
                }

            }

            TextInput
            {
                anchors
                {
                    top: parent.top
                    bottom: parent.bottom
                    right: parent.right
                    left: parent.source.length ? img.right : parent.left
                    margins: 10
                }

                color: parent.textColor
                font.pointSize: 12
                font.bold: true
            }
        }


    }

}
