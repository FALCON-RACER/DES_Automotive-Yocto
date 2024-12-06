#!/bin/bash

SETTINGS=$(cat <<EOF

MACHINE ?= "raspberrypi4-64"
PREFERRED_VERSION_linux-raspberrypi = "6.1%"

EOF
)

echo "$SETTINGS" >> ../build/conf/local.conf
