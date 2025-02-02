SUMMARY = "Enable autologin for on tty1"
DESCRIPTION = "Automatic login on tty1"
LICENSE = "CLOSED"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "file://autologin.conf"

do_install() {
    install -d ${D}${systemd_system_unitdir}/getty@tty1.service.d/

    install -m 0644 ${WORKDIR}/autologin.conf \
        ${D}${systemd_system_unitdir}/getty@tty1.service.d/autologin.conf
}

FILES:${PN} += "${systemd_system_unitdir}/getty@tty1.service.d/autologin.conf"

inherit systemd

RDEPENDS:${PN} += "systemd"
