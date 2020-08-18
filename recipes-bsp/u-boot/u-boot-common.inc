LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS += "bison-native"

UBOOT_SRC ?= "git://github.com/nsdrude/varigit-uboot-imx;protocol=git"
SRCBRANCH = "imx_v2020.04_5.4.24_2.1.0-imx8mn_var_som-brd-files"
SRCREV = "d1cd843c718fbb4d9582850795fc3adb3bb2e313"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

