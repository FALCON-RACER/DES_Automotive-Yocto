SUMMARY = "Custom infotainment image with RaspberryPi4b and Qt6"

DESCRIPTION = "Custom infotainment image for SEA-ME DES module"

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE ?= "8192"

IMAGE_INSTALL += "\
	qtbase \
	qtdeclarative \
	qtquick3d \
	qtquicktimeline \
	qtserialbus \
	qtremoteobjects \
	qtscxml \
	qtwayland \
	qttools \
	weston \
	weston-init \
	can-utils \
	init-scripts \
	instrument-cluster \
	head-unit \
"




