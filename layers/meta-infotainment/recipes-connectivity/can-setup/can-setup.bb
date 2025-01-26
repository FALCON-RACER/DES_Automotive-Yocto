SUMMARY = "CAN setup service file"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://can-setup.service"

inherit systemd

do_install() {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/can-setup.service ${D}${systemd_unitdir}/system/can-setup.service
}

FILES_${PN} += "${systemd_unitdir}/system/can-setup.service"
SYSTEMD_SERVICE:${PN} = "can-setup.service"

RDEPENDS_${PN} += "iproute2 can-utils"

