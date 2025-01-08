SUMMARY = "Custom Wayland Layer Manager"
DESCRIPTION = "QtWaylandCompositor-based custom Wayland compositor and client"
LICENSE = "CLOSED"

SRC_URI = " \
    file://CMakeLists.txt \
    file://main.cpp \
    file://resources.qrc \
    file://qml/main.qml \
    file://qml/CompositorScreen.qml \
    file://wayland-layer-manager.service \
"

S = "${WORKDIR}"

DEPENDS = "qtbase qtdeclarative qtdeclarative-native qtwayland qtwayland-native"

inherit cmake qt6-cmake

FILES:${PN} += "${bindir}/*"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/wayland-layer-manager ${D}${bindir}/wayland-layer-manager

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/wayland-layer-manager.service ${D}${systemd_unitdir}/system/wayland-layer-manager.service
}

FILES:${PN} += "${systemd_system_unitdir}/wayland-layer-manager.service"
SYSTEMD_SERVICE:${PN} = "wayland-layer-manager.service"

