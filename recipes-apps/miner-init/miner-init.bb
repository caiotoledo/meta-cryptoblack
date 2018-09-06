SUMMARY = "Script to initialize cpuminer-multi at boot"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

INITSCRIPT_NAME = "init-cpuminer"
INITSCRIPT_PARAMS = "defaults 99 10"

SRC_URI = "file://init-cpuminer"

DEPENDS = "cpuminer-multi"
RDEPENDS_${PN} = "cpuminer-multi"

# set your email user in local.conf
EMAIL ?= ""
MIRROR ?= ""

do_install_append() {
	install -d ${D}/etc/init.d
	install -m 0755 ${WORKDIR}/init-cpuminer ${D}/etc/init.d

	sed -i 's/%EMAIL%/${EMAIL}/g' ${D}/etc/init.d/init-cpuminer
	sed -i 's/%MIRROR%/${MIRROR}/g' ${D}/etc/init.d/init-cpuminer
}

inherit update-rc.d
