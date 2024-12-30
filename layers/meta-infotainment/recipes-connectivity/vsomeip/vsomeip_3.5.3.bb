SUMMARY = "vSomeIP - SOME/IP Protocol Implementation"
DESCRIPTION = "vSomeIP implements the Scalable service-Oriented MiddlewarE over IP (SOME/IP) protocol."
HOMEPAGE = "https://github.com/COVESA/vsomeip"
LICENSE = "CLOSED"


SRC_URI = "git://github.com/COVESA/vsomeip.git;branch=master;protocol=https"
SRCREV = "6461369b3874c844642c9adaac9d1b7406794ab8"

DEPENDS = "boost cmake pkgconfig"

# 소스 경로 및 빌드 경로 설정
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

# Configure 단계: CMake 빌드 설정
do_configure() {
    cmake -B ${B} -S ${S} ${EXTRA_OECMAKE}
}

# Compile 단계: CMake 빌드 실행
do_compile() {
    cmake --build ${B} -- -j${@oe.utils.cpu_count()}
}

# Install 단계: 빌드 결과를 설치
do_install() {
    # CMake 설치 수행
    cmake --install ${B} --prefix=${D}/usr

    # 헤더 파일 설치
    if [ -d "${S}/interface/vsomeip" ]; then
        install -d ${D}/usr/include/vsomeip
        cp -r ${S}/interface/vsomeip/* ${D}/usr/include/vsomeip/
        echo "Install successed."
    else
        echo "Error: ${S}/interface/vsomeip directory does not exist."
        exit 1
    fi

    # pkgconfig 파일 설치 및 경로 수정
    install -d ${D}${libdir}/pkgconfig
    if [ -f "${B}/vsomeip3.pc" ]; then
        sed -i "s|${D}||g" ${B}/vsomeip3.pc
        install -m 0644 ${B}/vsomeip3.pc ${D}${libdir}/pkgconfig/
    else
        echo "Error: ${B}/vsomeip3.pc not found."
        exit 1
    fi

    # 불필요한 디렉토리 제거
    rm -rf ${D}/usr/etc
}

# 패키지 파일 정의
FILES:${PN} += "\
    /usr/lib/libvsomeip*.so* \
    /usr/include/vsomeip/* \
    ${libdir}/pkgconfig/vsomeip3.pc \
"

# QA 검사 스킵 설정
INSANE_SKIP:${PN} = "installed-vs-shipped"
INSANE_SKIP:${PN} += "pkgconfig"


