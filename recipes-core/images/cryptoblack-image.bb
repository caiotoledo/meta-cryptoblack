SUMMARY = "A image to create a Beaglebone Black Miner"

LICENSE = "MIT"

IMAGE_INSTALL_append = "\
	kernel-modules \
	packagegroup-core-boot \
	packagegroup-core-ssh-openssh \
	miner-init \
"

IMAGE_INSTALL_append_beaglebone-green-wifi = "\
	wl18xx-fw \
	dhcp-client \
	wifi-init \
"

IMAGE_BOOT_FILES_append = " zImage am335x-bone.dtb am335x-boneblack.dtb uEnv.txt"

# Boot files for beaglebone green wifi:
BOOT_FILES_BEAGLEBONE_GREEN = "am335x-bonegreen-wireless.dtb am335x-bonegreen.dtb"
IMAGE_BOOT_FILES_append_beaglebone-green-wifi = " ${BOOT_FILES_BEAGLEBONE_GREEN}"

IMAGE_INSTALL_FOR_ARM = "kernel-devicetree"
IMAGE_INSTALL_append = "${@bb.utils.contains('TARGET_SYS', 'arm', " ${IMAGE_INSTALL_FOR_ARM}", "", d )}"

TOOLCHAIN_TARGET_TASK_append = " kernel-devsrc"

inherit core-image
