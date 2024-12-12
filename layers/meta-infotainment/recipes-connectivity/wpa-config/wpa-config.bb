SUMMARY = "Connect SEA:ME Wifi"
LICENSE = "CLOSED"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "file://wpa-supplicant-wlan0.service \
           file://udhcpc-i-wlan0.service \
           file://route-i-wlan0.service \
           "

inherit systemd

S = "${WORKDIR}"
SYSTEMD_SERVICE:${PN} = "wpa-supplicant-wlan0.service \
                         udhcpc-i-wlan0.service \
                         route-i-wlan0.service \
                         "
SYSTEMD_AUTO_ENABLE:${PN} = "enable"

do_install() {
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 wpa-supplicant-wlan0.service ${D}${systemd_unitdir}/system
    install -m 0644 udhcpc-i-wlan0.service ${D}${systemd_unitdir}/system
    install -m 0644 route-i-wlan0.service ${D}${systemd_unitdir}/system
}

FILES:${PN} += "${systemd_unitdir}/system/wpa-supplicant-wlan0.service"
FILES:${PN} += "${systemd_unitdir}/system/udhcpc-i-wlan0.service"
FILES:${PN} += "${systemd_unitdir}/system/route-i-wlan0.service"

