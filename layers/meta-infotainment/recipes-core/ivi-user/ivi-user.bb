SUMMARY = "Recipe for creating ivi-user"
DESCRIPTION = "This recipe creates ivi-user and ivi-group using useradd.bbclass"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = "\
	file://falcon \
"

S = "${WORKDIR}"

EXCLUDE_FROM_WORLD = "1"

inherit useradd

USERADD_PACKAGES = "${PN}"

#    -u: uid
#    -g: primary group
#    -r: system user
#    -s: shell
#    -d: home directory
USERADD_PARAM:${PN} = "-u 1000 -g ivi-group -G input -d /home/ivi-user -r -s /bin/sh ivi-user"
GROUPADD_PARAM:${PN} = "-g 1000 ivi-group"

INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

do_install () {
        install -d -m 755 ${D}${datadir}/ivi-user
        install -p -m 644 falcon ${D}${datadir}/ivi-user/
        chown -R ivi-user ${D}${datadir}/ivi-user
        chgrp -R ivi-group ${D}${datadir}/ivi-user
}

FILES:${PN} = "${datadir}/ivi-user/* ${sysconfdir}/sudoers.d/ivi-user"
