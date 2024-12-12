# Delete default weston.ini to prevent conflict

do_install:append() {
    rm -f ${D}${sysconfdir}/xdg/weston/weston.ini
}
