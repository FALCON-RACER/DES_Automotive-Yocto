SUMMARY = "Head Unit Recipe"
DESCRIPTION = "SEA:ME DES03 Head Unit application recipe"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "\
    git://github.com/FALCON-RACER/DES_Head-Unit.git;protocol=https;branch=main \
    file://head-unit.service \
"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git/apps/HeadUnit"

inherit qt6-cmake systemd


DEPENDS +=" \
    qtbase \
    qtdeclarative \
    qtdeclarative-native \
    qtwayland \
    qtwebengine \
    qtmultimedia \
    qt5compat \
"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/head-unit ${D}${bindir}

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/head-unit.service ${D}${systemd_unitdir}/system/head-unit.service
}

FILES:${PN} += "${systemd_unitdir}/system/head-unit.service"
SYSTEMD_SERVICE:${PN} = "head-unit.service"
