SUMMARY = "vSomeIP Example Application"
DESCRIPTION = "A simple service and client example using vSomeIP."

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit cmake

DEPENDS += "vsomeip boost"

SRC_URI = "\
    file://CMakeLists.txt \
    file://src/service-example.cpp \
    file://src/client-example.cpp \
"

S = "${WORKDIR}"

EXTRA_OECMAKE += "\
    -DCMAKE_INSTALL_PREFIX=/usr \
"

FILES:${PN} += "${bindir}/service-example"
FILES:${PN} += "${bindir}/client-example"
