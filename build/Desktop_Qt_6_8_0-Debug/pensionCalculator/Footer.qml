import QtQuick
import QtQuick.Layouts

Rectangle
{

    Layout.minimumHeight: 30
    Layout.maximumHeight: 30

    RowLayout
    {
        anchors.fill: parent
        uniformCellSizes: true

        Text
        {
            Layout.fillWidth: true
            Layout.leftMargin: 10
            Layout.fillHeight: true
            text: "Δημήτρης Νταλέτσος"
            color: "black"
            horizontalAlignment: Text.AlignLeft
            font
            {
                pointSize: 12
            }
        }

        Text
        {
            Layout.rightMargin: 10
            Layout.fillWidth: true
            Layout.fillHeight: true
            text: "Copyright © 2024"
            color: "black"
            horizontalAlignment: Text.AlignRight
            font
            {
                pointSize: 12
            }
        }
    }

}
