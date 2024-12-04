#!/bin/sh

export XDG_RUNTIME_DIR=/run/user/0
export WAYLAND_DISPLAY=wayland-1  # DSI

/usr/bin/InstrumentCluster
