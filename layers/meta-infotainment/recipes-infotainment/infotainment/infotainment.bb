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
    qtwebengine \
    qtmultimedia \
    qt5compat \
    qtsvg \
"

GRAPHICS_PACKAGES = "\
    mesa \
    kmscube \
    wayland \
    wayland-protocols \
    ivi-compositor \
    gst-devtools \
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    gstreamer1.0-plugins-bad \
    gstreamer1.0-plugins-good \
    gstreamer1.0-libav \
    gstreamer1.0-meta-base \
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
"

PIRACER_PACKAGES = "\
"

FONT_PACKAGES = "\
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
"

IMAGE_INSTALL += "\
    ${SYSTEM_PACKAGES} \
    ${NETWORK_PACKAGES} \
    ${QT_PACKAGES} \
    ${GRAPHICS_PACKAGES} \
    ${APPLICATION_PACKAGES} \
    ${PIRACER_PACKAGES} \
    ${CUSTOM_PACKAGES} \
    ${FONT_PACKAGES} \
"
