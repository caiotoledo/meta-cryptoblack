FILESEXTRAPATHS_prepend := "${THISDIR}/${MACHINE}:"
SRC_URI += "${@bb.utils.contains('MACHINE', 'beaglebone-green-wifi', "file://defconfig", "", d )}"

KERNEL_DEVICETREE_append = "${@bb.utils.contains('MACHINE', 'beaglebone-green-wifi', " am335x-bonegreen-wireless.dtb", "", d )}"
