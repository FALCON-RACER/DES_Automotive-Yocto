# DES_Automotive-Yocto

This repository is for building Yocto Linux infotainment system for Raspberry Pi 4B.

## 📌 1. How to Build

```sh
cd DES_Automotive-Yocto
scripts/install_layers.sh
source layers/poky/oe-init-build-env
../scripts/add_layers.sh
../scripts/append_local_conf.sh
bitbake infotainment
```

## 📌 2. Directory Structure
#### layers
all the layers (poky, meta-qt6, meta-raspberrypi, etc) will be here including our custom layer (meta-infotainment)
#### layers/recipes-bsp
BSP for Raspberry Pi 4B
#### layers/recipes-infotainment
recipes for a custom image
#### layers/recipes-connectivity
Bluetooth, VSOMEIP, SSH, CAN, etc.
#### layers/recipes-kernel
fix linux kernel version to a specific one
#### layers/recipes-core
automatic login and a user (for runnin applications with limited authority) creation
#### layers/recipes-qt6
Qt6 recipes bbappends
#### layers/recipes-apps
recipes for applications
#### layers/recipes-graphics
a recipe for IVI graphical compositor using QtWayland

## 📌 3. Tips
### 3.1. Working with SSH
Connect a keyboard to a Raspberry Pi and type following commands:
```
sudo -
systemctl stop ivi-compositor
```
Then set a password using `passwd` and check the RPI's IP address.
Now you are ready to access your Raspberry Pi through SSH.

### 3.2. How to start/stop a service
Currently we have instrument-cluster, head-unit, ivi-compositor, service-manager servicies.
When you want to run a service: `systemctl start [service name]`, and when you want to stop a service: `systemctl stop [service name]`

### 3.3. How to check service log
`journalctl -u [service name]`
