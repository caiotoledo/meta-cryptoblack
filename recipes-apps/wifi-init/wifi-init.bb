SUMMARY = "Script to connect wifi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

INITSCRIPT_NAME = "init-wifi"
INITSCRIPT_PARAMS = "defaults 90 20"

SRC_URI = "file://init-wifi"

DEPENDS = "wpa-supplicant"
RDEPENDS_${PN} = "wpa-supplicant"

do_install_append() {
	install -d ${D}/etc/init.d
	install -m 0755 ${WORKDIR}/init-wifi ${D}/etc/init.d
}

inherit update-rc.d
