SUMMARY = "CAN setup script"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit update-rc.d

INITSCRIPT_NAME = "can-setup"
INITSCRIPT_PARAMS = "defaults"

SRC_URI = "file://can-setup"

do_install() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/can-setup ${D}${sysconfdir}/init.d/can-setup
}

RDEPENDS_${PN} += "iproute2 can-utils"
