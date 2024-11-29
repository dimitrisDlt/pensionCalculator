import QtQuick
import QtQuick.Layouts
import QtQuick.Effects

Rectangle
{
    property string headerTitle

    id: header
    Layout.minimumHeight: 80
    Layout.maximumHeight: 80
    Layout.fillWidth: true

    color: "#16423C"
    layer.enabled: true
    layer.effect: MultiEffect
    {
        shadowEnabled: true
        shadowBlur: 0.8
        shadowColor: "black"
    }

    Text
    {
        anchors.fill: parent
        text: header.headerTitle
        color: "white"
        font
        {
            pointSize: 22
            bold: true
        }
        horizontalAlignment: Text.AlignHCenter
        verticalAlignment: Text.AlignVCenter
    }
}
