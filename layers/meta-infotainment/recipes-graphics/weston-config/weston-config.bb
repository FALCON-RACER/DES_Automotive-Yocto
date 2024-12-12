DESCRIPTION = "Custom Weston configuration for multi-display setup"
LICENSE = "CLOSED"

SRC_URI = "file://weston.ini"

DEPENDS += "wayland weston"
RDEPENDS_${PN} += "weston weston-init"

do_install() {
    install -d ${D}${sysconfdir}/xdg/weston/
    install -m 0644 ${WORKDIR}/weston.ini ${D}${sysconfdir}/xdg/weston/weston.ini
}
