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
    wayland \
    wayland-layer-manager \
"

APPLICATION_PACKAGES = "\
    instrument-cluster \
    head-unit \
"

CUSTOM_PACKAGES = "\
    init-scripts \
    wpa-config \
    sshd-config \
    autologin \
    run-apps \
"

IMAGE_INSTALL += "\
    ${SYSTEM_PACKAGES} \
    ${NETWORK_PACKAGES} \
    ${QT_PACKAGES} \
    ${GRAPHICS_PACKAGES} \
    ${APPLICATION_PACKAGES} \
    ${CUSTOM_PACKAGES} \
"
