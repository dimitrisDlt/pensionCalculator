import QtQuick
import QtQuick.Controls
import QtQuick.Controls.Material

Rectangle
{
    anchors.fill: parent
    Material.theme: Material.Dark
    Material.accent: Material.Purple
    Button
    {
        anchors.centerIn: parent
        text: "Hello"
    }

}
