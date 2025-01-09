SUMMARY = "Custom IVI Compositor"
DESCRIPTION = "QtWaylandCompositor-based custom Wayland compositor and client"
LICENSE = "CLOSED"

SRC_URI = " \
    file://CMakeLists.txt \
    file://main.cpp \
    file://resources.qrc \
    file://qml/main.qml \
    file://qml/CompositorScreen.qml \
    file://ivi-compositor.service \
"

S = "${WORKDIR}"

DEPENDS = "qtbase qtdeclarative qtdeclarative-native qtwayland qtwayland-native mesa"

inherit cmake qt6-cmake systemd

FILES:${PN} += "${bindir}/*"
FILES:${PN} += "${systemd_unitdir}/system/ivi-compositor.service"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/ivi-compositor ${D}${bindir}/ivi-compositor

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/ivi-compositor.service ${D}${systemd_unitdir}/system/ivi-compositor.service
}

SYSTEMD_SERVICE:${PN} = "ivi-compositor.service"

