SUMMARY = "Custom infotainment image with RaspberryPi4b and Qt6"

DESCRIPTION = "Custom infotainment image for SEA-ME DES module"

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"

SYSTEM_PACKAGES = "\
    systemd \
"

NETWORK_PACKAGES = "\
    wpa-supplicant \
    can-utils \
    openssh \
"

QT_PACKAGES = "\
    qtbase \
    qtdeclarative \
    qtwayland \
    qttools \
"

GRAPHICS_PACKAGES = "\
    weston \
    weston-init \
"

APPLICATION_PACKAGES = "\
    instrument-cluster \
    head-unit \
"

CUSTOM_PACKAGES = "\
    init-scripts \
    run-apps \
    weston-config \
"
IMAGE_INSTALL += "\
    ${SYSTEM_PACKAGES} \
    ${NETWORK_PACKAGES} \
    ${GRAPHICS_PACKAGES} \
    ${QT_PACKAGES} \
    ${APPLICATION_PACKAGES} \
    ${CUSTOM_PACKAGES} \
"
