SUMMARY = "Head Unit Recipe"
DESCRIPTION = "SEA:ME DES03 Head Unit application recipe"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/FALCON-RACER/DES_Head-Unit.git;protocol=https;branch=main \
	file://HeadUnit.sh \
	file://HeadUnit.service"

SRCREV = "6a77fe7da14297f26bbfef43c2af05ee5330346d"

S = "${WORKDIR}/git/HeadUnit"

inherit qt6-cmake

DEPENDS +=" \
	qtdeclarative \
	qtdeclarative-native \
	qtbase \
	qtquick3d \
	qtquicktimeline \
	qtwayland \
	qttools \
"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/HeadUnit ${D}${bindir}

    # Add Head Unit launch script
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/HeadUnit.sh ${D}${bindir}/HeadUnit.sh

    # Add Systemd service file
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/HeadUnit.service ${D}${systemd_system_unitdir}/HeadUnit.service
}

# Add the service file to the default package
FILES:${PN} += "/lib/systemd/system/HeadUnit.service"

# Activate the service automatically
SYSTEMD_SERVICE:${PN} = "HeadUnit.service"  
