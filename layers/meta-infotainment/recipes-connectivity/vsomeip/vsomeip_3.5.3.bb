SUMMARY = "vSomeIP - SOME/IP Protocol Implementation"
DESCRIPTION = "vSomeIP implements the Scalable service-Oriented MiddlewarE over IP (SOME/IP) protocol."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/COVESA/vsomeip.git;branch=release_3.5.3;protocol=https"
SRCREV = "444737fcb1010086a4798c2adfe4e9af939c9b39"

DEPENDS = "boost cmake pkgconfig"

# Set source path and build path
S = "${WORKDIR}/git"
B = "${WORKDIR}/build"

inherit cmake pkgconfig
DEPENDS += "boost"

EXTRA_OECMAKE += "\
    -DCMAKE_INSTALL_PREFIX=${D}/usr \
    -DBOOST_ROOT=${STAGING_DIR_HOST}/usr \
    -DBOOST_INCLUDEDIR=${STAGING_DIR_HOST}/usr/include \
    -DBOOST_LIBRARYDIR=${STAGING_DIR_HOST}/usr/lib \
"

# Configure step: CMake build configuration
do_configure() {
    cmake -B ${B} -S ${S} ${EXTRA_OECMAKE}
}

# Compile step: Execute CMake build
do_compile() {
    cmake --build ${B} -- -j${@oe.utils.cpu_count()}
}

# Install step: Install build results
do_install() {
    # Perform CMake installation
    cmake --install ${B} --prefix=${D}/usr

    # Install header files
    if [ -d "${S}/interface/vsomeip" ]; then
        install -d ${D}/usr/include/vsomeip
        cp -r ${S}/interface/vsomeip/* ${D}/usr/include/vsomeip/
        echo "Install succeeded."
    else
        echo "Error: ${S}/interface/vsomeip directory does not exist."
        exit 1
    fi

    # Install pkgconfig file and modify path
    install -d ${D}${libdir}/pkgconfig
    if [ -f "${B}/vsomeip3.pc" ]; then
        sed -i "s|${D}||g" ${B}/vsomeip3.pc
        install -m 0644 ${B}/vsomeip3.pc ${D}${libdir}/pkgconfig/
    else
        echo "Error: ${B}/vsomeip3.pc not found."
        exit 1
    fi

    # Remove unnecessary directories
    rm -rf ${D}/usr/etc
}

# Define package files
FILES:${PN} += "\
    /usr/lib/libvsomeip*.so* \
    /usr/include/vsomeip/* \
    ${libdir}/pkgconfig/vsomeip3.pc \
"
