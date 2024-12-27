import QtQml
import QtQuick
import QtWayland.Compositor
import QtWayland.Compositor.IviApplication
import QtQml.Models

WaylandCompositor {
    id: comp

    ListModel {
        id: emulatedScreens
        ListElement { name: "HDMI2"; virtualX: 0; virtualY: 0; width: 1024; height: 600 }
        ListElement { name: "DSI1"; virtualX: 1024; virtualY: 0; width: 400; height: 1280 }
    }

    property bool emulated: Qt.application.screens.length < 2

    Instantiator {
        id: screens
        model: emulated ? emulatedScreens : Qt.application.screens

        delegate: CompositorScreen {
            surfaceArea.color: name === "HDMI2" ? "blue" : "green"
            compositor: comp
            screen: emulated ? Qt.application.screens[0] : modelData
            Component.onCompleted: if (!comp.defaultOutput) comp.defaultOutput = this
            position: Qt.point(virtualX, virtualY)
            windowed: emulated
            transform: name === "DSI1" ? WaylandOutput.Transform90 : WaylandOutput.TransformNormal
        }
    }

    Component {
        id: shellSurfaceItemComponent
        ShellSurfaceItem {
            shellSurface: null
            anchors.fill: parent
        }
    }

    IviApplication {
        onIviSurfaceCreated: (iviSurface) => {
            console.log("New IVI Surface created: " + iviSurface.iviId);
            let output;

            if (iviSurface.iviId === 1000) {
                output = screens.objectAt(0);
                console.log("Mapping the surface to HDMI2");
            } else if (iviSurface.iviId === 2000) {
                output = screens.objectAt(1);
                console.log("Mapping the surface to DSI1");
            } else {
                console.warn("Unexpected IVI ID: ", iviSurface.iviId);
                return;
            }
            const item = shellSurfaceItemComponent.createObject(output.surfaceArea,  {
                shellSurface: iviSurface,
            });
        }
    }
}
