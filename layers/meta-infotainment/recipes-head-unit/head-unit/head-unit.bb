SUMMARY = "Head Unit Recipe"
DESCRIPTION = "SEA:ME DES03 Head Unit application recipe"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/FALCON-RACER/DES_Head-Unit.git;protocol=https;branch=main"

SRCREV = "42092bb4007d94663a4cf2af8f1552fe7c4f1fee"

S = "${WORKDIR}/git/apps/HeadUnit"

inherit qt6-cmake

DEPENDS +=" \
	qtbase \
	qtdeclarative \
	qtdeclarative-native \
	qtwayland \
"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/head-unit ${D}${bindir}
}
