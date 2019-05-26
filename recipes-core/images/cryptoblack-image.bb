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

IMAGE_INSTALL_append = " kernel-modules kernel-devicetree"
IMAGE_BOOT_FILES_append = " zImage am335x-bone.dtb am335x-boneblack.dtb am335x-bonegreen.dtb am335x-bonegreen-wireless.dtb uEnv.txt"

TOOLCHAIN_TARGET_TASK_append = " kernel-devsrc"

inherit core-image
