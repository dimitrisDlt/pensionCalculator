import QtQuick
import QtQuick.Effects
import QtQuick.Layouts
import QtQuick.Controls

Rectangle
{
    id: loginPage
    anchors.fill: parent
    color: "#E9EFEC"

    Rectangle
    {
        id: logoView
        anchors
        {
            top: parent.top
            bottom: parent.bottom
            left: parent.left
            rightMargin: 20
        }
        width: 400

        color: "#16423C"

        layer.enabled: true
        layer.effect: MultiEffect
        {
            shadowEnabled: true
            shadowBlur: 0.8
            shadowColor: "black"
            shadowHorizontalOffset: 0
            shadowVerticalOffset: 0
            shadowOpacity: 1.0
        }

        Image
        {
            id: logo
            anchors
            {
                top: parent.top
                horizontalCenter: logoView.horizontalCenter
                topMargin: 150
            }

            width: 150
            height: 150
            source: "qrc:/assets/money-bills-solid.svg"
        }

        Text
        {	id: titleLabel
            anchors
            {
                top: logo.bottom
                right: parent.right
                left: parent.left
                topMargin: 50
            }
            height: 70

            text: "PensionCalculator."
            color: "white"
            font.pointSize: 28
            font.bold: true
            horizontalAlignment: Text.AlignHCenter
        }

        Text
        {
            anchors
            {
                top: titleLabel.bottom
                right: parent.right
                left: parent.left
            }
            height: 70

            text: "Μία εφαρμογή υπολογισμού ποσού κύριας και επικουρικής σύνταξης."
            color: "white"
            font.pointSize: 12
            font.bold: false
            horizontalAlignment: Text.AlignHCenter
            wrapMode: Text.WordWrap
        }

    }

    Rectangle
    {
        id: loginView
        anchors
        {
            top: parent.top
            bottom: parent.bottom
            right: parent.right
            left: logoView.right
        }

        color: "transparent"

        ColumnLayout
        {
            anchors.fill: parent
            spacing: 5
            uniformCellSizes: false

            Rectangle
            {
                id: loginPageTopSpacer
                Layout.maximumHeight: 80
                Layout.minimumHeight: 80
                Layout.fillWidth: true
                color: "transparent"
            }

            Text
            {
                id: welcomeLabel
                Layout.maximumHeight: 100
                Layout.minimumHeight: 100
                Layout.fillWidth: true

                text: "Καλώς Ορίσατε!"
                color: "black"
                font
                {
                    pointSize: 32
                    bold: false
                    italic: true
                }
                horizontalAlignment: Text.AlignHCenter
            }

            Text
            {
                id: passwordPromptLabel
                Layout.maximumHeight: 100
                Layout.minimumHeight: 100
                Layout.fillWidth: true

                text: "Παρακαλώ εισάγετε τον κωδικό για να συνεχίσετε."
                font
                {
                    pointSize: 14
                }
                horizontalAlignment: Text.AlignHCenter
            }

            MyInput
            {
                id: passwordInput
                Layout.alignment: Qt.AlignHCenter
                source: "qrc:/assets/key-solid.svg"
            }

            Label
            {
                id: errorLabel
                Layout.maximumHeight: 100
                Layout.minimumHeight: 100
                Layout.fillWidth: true
                text: ""
                color: "red"
                font
                {
                    pointSize: 12
                }
            }

            Rectangle
            {
                id: loginPageBottomSpacer
                Layout.fillHeight: true
                Layout.fillWidth: true

                color: "transparent"
            }

            Rectangle
            {
                Layout.maximumHeight: 100
                Layout.minimumHeight: 100
                Layout.fillWidth: true

                color: "transparent"

                MyButton
                {
                    anchors
                    {
                        right: parent.right
                        rightMargin: 50
                        verticalCenter: parent.verticalCenter
                    }

                    onClicked:
                    {
                        loginPageController.onLoginButtonClicked(passwordInput.text)

                    }

                    buttonLabel: "LOGIN"
                }
            }

            Footer
            {
                id: loginPageFooter
                Layout.fillWidth: true

                color: "transparent"
            }
        }
    }
}
