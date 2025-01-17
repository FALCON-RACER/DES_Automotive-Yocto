#!/bin/bash

LAYER_DIR=$(realpath "$(dirname "$0")/../layers")

cd "$LAYER_DIR"

git clone -b kirkstone git://git.yoctoproject.org/poky.git
git clone -b 6.5.3 git://code.qt.io/yocto/meta-qt6.git
git clone -b kirkstone git://git.yoctoproject.org/meta-raspberrypi.git
git clone -b kirkstone https://github.com/openembedded/meta-openembedded.git
