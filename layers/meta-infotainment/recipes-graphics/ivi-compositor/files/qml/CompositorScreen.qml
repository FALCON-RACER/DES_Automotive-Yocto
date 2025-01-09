import QtQuick
import QtWayland.Compositor
import QtQuick.Window

WaylandOutput {
    id: screen
    property variant viewsBySurface: ({})
    property alias surfaceArea: background
    property alias screen: win.screen
    sizeFollowsWindow: true

    property bool windowed: false

    window: Window {
        id: win
        x: Screen.virtualX
        y: Screen.virtualY
        width: modelData ? modelData.width : 800
        height: modelData ? modelData.height : 600
        visibility: windowed ? Window.Windowed : Window.FullScreen
        visible: true

        Rectangle {
            id: background
            anchors.fill: parent
            color: "red"

            Text {
                id: quitText
                text: "Press Ctrl + Alt + Backspace to quit"
                color: "white"
                font.pixelSize: 20
                anchors.centerIn: parent
                horizontalAlignment: Text.AlignHCenter
                verticalAlignment: Text.AlignVCenter
            }
        }

        Shortcut {
            sequence: "Ctrl+Alt+Backspace"
            onActivated: Qt.quit()
        }
    }
}
