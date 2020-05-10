FILESEXTRAPATHS_prepend_beaglebone-green-wifi := "${THISDIR}/${MACHINE}:"

MY_DEFCONFIG_FILE = "\
	file://defconfig \
"
SRC_URI_prepend_beaglebone-green-wifi = "${MY_DEFCONFIG_FILE}"

KERNEL_DEVICETREE_append_beaglebone-green-wifi = " am335x-bonegreen-wireless.dtb"
