SUMMARY = "A image to create a Beaglebone Black Miner"

LICENSE = "MIT"

CORE_IMAGE_EXTRA_INSTALL += "\
	packagegroup-core-boot \
	packagegroup-core-ssh-openssh \
	miner-init \
"

IMAGE_INSTALL_append = " kernel-modules kernel-devicetree"
IMAGE_BOOT_FILES_append = " zImage am335x-bone.dtb am335x-boneblack.dtb am335x-bonegreen.dtb uEnv.txt"

inherit core-image
