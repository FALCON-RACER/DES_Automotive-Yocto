SUMMARY = "Instrument Cluster Recipe"
DESCRIPTION = "SEA:ME DES02 Instrument Cluster application recipe"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "\
    git://github.com/FALCON-RACER/DES_Head-Unit.git;protocol=https;branch=main \
    file://instrument-cluster.service \
"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git/apps/InstrumentCluster"

inherit qt6-cmake systemd

DEPENDS +=" \
    qtbase \
    qtwayland \
    qtdeclarative \
    qtdeclarative-native \
    qt5compat \
"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/instrument-cluster ${D}${bindir}

    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/instrument-cluster.service ${D}${systemd_unitdir}/system/instrument-cluster.service
}

FILES:${PN} += "${systemd_unitdir}/system/instrument-cluster.service"
SYSTEMD_SERVICE:${PN} = "instrument-cluster.service"
