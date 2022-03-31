# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017 NXP
# Copyright 2018-2019 Variscite Ltd.
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux kernel provided and supported by Variscite"
DESCRIPTION = "Linux kernel provided and supported by Variscite (based on the kernel provided by NXP) \
with focus on i.MX Family SOMs. It includes support for many IPs such as GPU, VPU and IPU."

require recipes-kernel/linux/linux-imx.inc

DEPENDS += "lzop-native bc-native"

DEFAULT_PREFERENCE = "1"

SRCBRANCH = "imx_4.14.98_2.0.0_ga_var01"
SRCBRANCH_imx8mn-var-som = "imx_4.14.98_2.3.0_var01"

LOCALVERSION_imx8mq-var-dart = "-imx8mq"
LOCALVERSION_imx8mm-var-dart = "-imx8mm"
LOCALVERSION_imx8mn-var-som = "-imx8mn"
LOCALVERSION_imx8qxp-var-som = "-imx8x"
LOCALVERSION_imx8qm-var-som = "-imx8qm"

KERNEL_DEFCONFIG = "${S}/arch/arm64/configs/imx8_var_defconfig"
DEFAULT_DTB_imx8mq-var-dart = "sd-lvds"
DEFAULT_DTB_imx8qxp-var-som = "sd"
DEFAULT_DTB_imx8qm-var-som = "lvds"
DEFAULT_DTB_PREFIX_imx8mq-var-dart = "fsl-imx8mq-var-dart"
DEFAULT_DTB_PREFIX_imx8qxp-var-som = "fsl-imx8qxp-var-som"
DEFAULT_DTB_PREFIX_imx8qm-var-som = "fsl-imx8qm-var-som"

KERNEL_SRC ?= "git://github.com/varigit/linux-imx;protocol=git"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH}"
SRCREV = "40628fe12c64c3560cdbd7daed8aa16fdacdefbf"
SRCREV_imx8mn-var-som = "39ed0f1e4fc8edae2d20bed16e8260e388484194"

S = "${WORKDIR}/git"

addtask copy_defconfig after do_patch before do_preconfigure
do_copy_defconfig () {
    cp ${KERNEL_DEFCONFIG} ${WORKDIR}/defconfig
}

pkg_postinst_kernel-devicetree_append () {
   rm -f $D/boot/devicetree-*
}

pkg_postinst_kernel-devicetree_append_imx8mq-var-dart () {
    cd $D/boot
    ln -s ${DEFAULT_DTB_PREFIX}-${DEFAULT_DTB}.dtb ${DEFAULT_DTB_PREFIX}.dtb
    ln -s ${DEFAULT_DTB_PREFIX}-${DEFAULT_DTB}-cb12.dtb ${DEFAULT_DTB_PREFIX}-cb12.dtb
}

pkg_postinst_kernel-devicetree_append_imx8qxp-var-som () {
    cd $D/boot
    ln -s ${DEFAULT_DTB_PREFIX}-${DEFAULT_DTB}.dtb ${DEFAULT_DTB_PREFIX}.dtb
}

pkg_postinst_kernel-devicetree_append_imx8qm-var-som () {
    cd $D/boot
    ln -s ${DEFAULT_DTB_PREFIX}-${DEFAULT_DTB}.dtb ${DEFAULT_DTB_PREFIX}.dtb
    ln -s fsl-imx8qm-var-spear-${DEFAULT_DTB}.dtb fsl-imx8qm-var-spear.dtb
    ln -s fsl-imx8qp-var-som-${DEFAULT_DTB}.dtb fsl-imx8qp-var-som.dtb
    ln -s fsl-imx8qp-var-spear-${DEFAULT_DTB}.dtb fsl-imx8qp-var-spear.dtb
}

COMPATIBLE_MACHINE = "(mx8)"
EXTRA_OEMAKE_append_mx8 = " ARCH=arm64"
