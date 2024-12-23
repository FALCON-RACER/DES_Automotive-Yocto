SUMMARY = "Run Instrument Cluster and Head Unit applications automatically on boot"
DESCRIPTION = "A script and systemd service to run GUI applications on Wayland using Weston"
LICENSE = "CLOSED"

SRC_URI = "file://run-apps \
           file://run-apps.service"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/run-apps ${D}${bindir}/run-apps

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/run-apps.service ${D}${systemd_system_unitdir}/run-apps.service
}

inherit systemd

SYSTEMD_SERVICE:${PN} = "run-apps.service"
SYSTEMD_AUTO_ENABLE = "enable"
FILES:${PN} += "${systemd_system_unitdir}/run-apps.service"

RDEPENDS:${PN} = "systemd qtwayland instrument-cluster head-unit"
