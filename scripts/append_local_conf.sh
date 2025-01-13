#!/bin/bash

SETTINGS=$(cat <<EOF

MACHINE ?= "raspberrypi4-64"
PREFERRED_VERSION_linux-raspberrypi = "6.1%"
DISTRO_FEATURES:append = " systemd bluetooth wayland pam opengl kms egl"
DISTRO_FEATURES:remove = " x11 sysvinit"
PREFERRED_PROVIDER_virtual/egl = "mesa"
PREFERRED_PROVIDER_virtual/libgl = "mesa"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"
DISTRO_FEATURES_BACKFILL_CONSIDERED = "sysvinit"
IMAGE_BOOT_FILES:append = " vc4-kms-dsi-waveshare-panel.dtbo;overlays/vc4-kms-dsi-waveshare-panel.dtbo"
LICENSE_FLAGS_ACCEPTED += "commercial"

EOF
)

CONF_DIR=$(realpath "$(dirname "$0")/../build/conf")

echo "$SETTINGS" >> "$CONF_DIR/local.conf"
