# Disable default sshd_config installation

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

do_install:append() {
    rm -f ${D}${sysconfdir}/ssh/sshd_config
}
