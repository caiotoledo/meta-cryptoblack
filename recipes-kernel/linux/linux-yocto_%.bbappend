FILESEXTRAPATHS_prepend := "${THISDIR}/${MACHINE}:"
SRC_URI_prepend_beaglebone-green-wifi = "\
	file://defconfig \
"

KERNEL_DEVICETREE_append_beaglebone-green-wifi = " am335x-bonegreen-wireless.dtb"
