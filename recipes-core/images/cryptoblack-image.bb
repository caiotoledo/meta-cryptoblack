SUMMARY = "A image to create a Beaglebone Black Miner"

LICENSE = "MIT"

CORE_IMAGE_EXTRA_INSTALL += "\
	packagegroup-core-boot \
	packagegroup-core-ssh-openssh \
	miner-init \
	${@bb.utils.contains('MACHINE', 'beaglebone-green-wifi', "wl18xx-fw", "", d )} \
	${@bb.utils.contains('MACHINE', 'beaglebone-green-wifi', "dhcp-client", "", d )} \
	${@bb.utils.contains('MACHINE', 'beaglebone-green-wifi', "wifi-init", "", d )} \
"

IMAGE_INSTALL_append = " kernel-modules"
IMAGE_BOOT_FILES_append = " zImage am335x-bone.dtb am335x-boneblack.dtb uEnv.txt"

BOOT_FILES_BEAGLEBONE_GREEN = "am335x-bonegreen-wireless.dtb am335x-bonegreen.dtb"
IMAGE_BOOT_FILES_append = "${@bb.utils.contains('MACHINE', 'beaglebone-green-wifi', " ${BOOT_FILES_BEAGLEBONE_GREEN}", "", d )}"

IMAGE_INSTALL_FOR_ARM = "kernel-devicetree"
IMAGE_INSTALL_append = "${@bb.utils.contains('MACHINE', 'beaglebone', " ${IMAGE_INSTALL_FOR_ARM}", "", d )}"
IMAGE_INSTALL_append = "${@bb.utils.contains('MACHINE', 'beaglebone-green-wifi', " ${IMAGE_INSTALL_FOR_ARM}", "", d )}"

TOOLCHAIN_TARGET_TASK_append = " kernel-devsrc"

inherit core-image
