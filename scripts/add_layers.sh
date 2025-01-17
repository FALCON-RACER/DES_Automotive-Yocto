#!/bin/bash

BUILD_DIR=$(realpath "$(dirname "$0")/../build")
LAYERS_DIR=$(realpath "$(dirname "$0")/../layers")

cd "$BUILD_DIR"

bitbake-layers add-layer "$LAYERS_DIR/meta-openembedded/meta-oe"
bitbake-layers add-layer "$LAYERS_DIR/meta-openembedded/meta-python"
bitbake-layers add-layer "$LAYERS_DIR/meta-qt6"
bitbake-layers add-layer "$LAYERS_DIR/meta-raspberrypi"
bitbake-layers add-layer "$LAYERS_DIR/meta-infotainment"
