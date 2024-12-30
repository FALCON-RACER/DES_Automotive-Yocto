#!/bin/bash

SETTINGS=$(cat <<EOF

MACHINE ?= "raspberrypi4-64"
PREFERRED_VERSION_linux-raspberrypi = "6.1%"
DISTRO_FEATURES:append = " systemd bluetooth wayland pam opengl kms"
DISTRO_FEATURES:remove = " x11 sysvinit"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"
DISTRO_FEATURES_BACKFILL_CONSIDERED = "sysvinit"

EOF
)

IMAGE_BOOT_FILES:append = " vc4-kms-dsi-waveshare-panel.dtbo;overlays/vc4-kms-dsi-waveshare-panel.dtbo"

echo "$SETTINGS" >> ../build/conf/local.conf
