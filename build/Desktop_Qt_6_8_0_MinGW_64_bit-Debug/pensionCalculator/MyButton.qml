import QtQuick
import QtQuick.Controls
import QtQuick.Effects

Button
{
    property string buttonLabel
    property color backgroundColor: "#16423C"
    property color borderColor: "#16423C"
    property color textColor: "white"

    id: myButton
    width: 200
    height: 40
    text: buttonLabel
    layer.enabled: true
    layer.effect: MultiEffect
    {
        shadowEnabled: true
        shadowBlur: 0.8
        shadowColor: "black"
    }

    ParallelAnimation
    {
        id: parallelAnimationEnter

        PropertyAnimation
        {
            id: backgroundColorAnimationEnter
            target: myButton
            properties: "backgroundColor"
            to: "#E9EFEC"
            duration: 500
        }

        PropertyAnimation
        {
            id: borderColorAnimationEnter
            target: myButton
            properties: "borderColor"
            to: "#16423C"
            duration: 500
        }

        PropertyAnimation
        {
            id: textColorAnimationEnter
            target: myButton
            properties: "textColor"
            to: "#16423C"
            duration: 500
        }
    }

    ParallelAnimation
    {
        id: parallelAnimationExit

        PropertyAnimation
        {
            id: backgroundColorAnimationExit
            target: myButton
            properties: "backgroundColor"
            to: "#16423C"
            duration: 500
        }

        PropertyAnimation
        {
            id: borderColorAnimationExit
            target: myButton
            properties: "borderColor"
            to: "#16423C"
            duration: 500
        }

        PropertyAnimation
        {
            id: textColorAnimationExit
            target: myButton
            properties: "textColor"
            to: "white"
            duration: 500
        }
    }
    MouseArea
    {
        anchors.fill: parent
        hoverEnabled: true

        onEntered:
        {
            parallelAnimationEnter.start()
        }

        onExited:
        {
            parallelAnimationExit.start()
        }
    }

    contentItem: Text
    {
        text: myButton.text
        color: myButton.textColor
        horizontalAlignment: Text.AlignHCenter
        verticalAlignment: Text.AlignVCenter
        font
        {
            pointSize: 14
            bold: true
        }
    }

    background: Rectangle
    {
        radius: 8
        color: myButton.backgroundColor
        border.color: myButton.borderColor
        border.width: 3
    }

}
