SUMMARY = "Service Manager Recipe"
DESCRIPTION = "SEA:ME DES02 Service Manager application recipe"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "\
    git://github.com/FALCON-RACER/DES_Head-Unit.git;protocol=https;branch=64-adding-ambient-light-on-hu \
    file://service-manager.service \
"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git/apps/ServiceManager"

inherit cmake systemd

DEPENDS +=" \
    vsomeip \
"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/server ${D}${bindir}

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/service-manager.service ${D}${systemd_unitdir}/system/service-manager.service
}

FILES:${PN} += "${systemd_unitdir}/system/service-manager.service"
SYSTEMD_SERVICE:${PN} = "service-manager.service"
