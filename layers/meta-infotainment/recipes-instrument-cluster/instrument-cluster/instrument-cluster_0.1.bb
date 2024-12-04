SUMMARY = "Instrument Cluster Recipe"
DESCRIPTION = "SEA:ME DES02 Instrument Cluster application recipe"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/FALCON-RACER/DES_Instrument-Cluster.git;protocol=https;branch=21-comment-out-exception-throws-for-test \
	file://InstrumentCluster.sh \
	file://InstrumentCluster.service"

SRCREV = "ad0142f49dabfbfbd63db58933cdb6b682ef61aa"

S = "${WORKDIR}/git/instrument_cluster"

inherit qt6-cmake

DEPENDS +=" \
	i2c-tools \
	qtbase \
	qtquick3d \
	qtquicktimeline \
	qtserialbus \
	qtremoteobjects \
	qtscxml \
	qtwayland \
	qttools \
	qtdeclarative \
	qtdeclarative-native \
"

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${B}/InstrumentCluster ${D}${bindir}

    # Add InstrumentCluster launch script
    install -d ${D}${bindir}
    install -m 0755 ${WORKDIR}/InstrumentCluster.sh ${D}${bindir}/InstrumentCluster.sh

    # Add Systemd service file
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/InstrumentCluster.service ${D}${systemd_system_unitdir}/InstrumentCluster.service
}

# Add the service file to the default package
FILES:${PN} += "/lib/systemd/system/InstrumentCluster.service"

# Activate the service automatically
SYSTEMD_SERVICE:${PN} = "InstrumentCluster.service"  
