SUMMARY = "Custom SSHD Configuration to debug RPI while displays are not working"
DESCRIPTION = "Updates sshd_config to support IPv6 and restarts SSH service"
LICENSE = "CLOSED"

SRC_URI = " \
    file://sshd_config \
    file://ssh.service \
"

inherit systemd

do_install() {
    install -d ${D}${sysconfdir}/ssh
    install -m 0644 ${WORKDIR}/sshd_config ${D}${sysconfdir}/ssh/sshd_config

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/ssh.service ${D}${systemd_unitdir}/system/ssh.service
}

SYSTEMD_SERVICE:${PN} = "ssh.service"
SYSTEMD_AUTO_ENABLE:${PN} = "enable"
