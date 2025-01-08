SUMMARY = "Instrument Cluster Recipe"
DESCRIPTION = "SEA:ME DES02 Instrument Cluster application recipe"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/FALCON-RACER/DES_Head-Unit.git;protocol=https;branch=main"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git/apps/InstrumentCluster"

inherit qt6-cmake

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
}
