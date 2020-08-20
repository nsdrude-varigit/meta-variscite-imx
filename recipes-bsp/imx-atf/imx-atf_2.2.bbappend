FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " file://0001-imx8m-Adjust-struct-dram_timing_info-to-match-u-boot.patch"
SRC_URI_append_imx8mm-var-dart = " file://0002-imx8mm-Allocate-UART4-to-A53-domain.patch"
SRC_URI_append_imx8mn-var-som = " file://0003-imx8mn-Allocate-UART4-to-A53-domain.patch"
SRC_URI_append_imx8mn-var-som = " file://0004-imx8mn-Set-IMX_BOOT_UART_BASE-for-console-on-uart4.patch"
SRC_URI_append_imx8mm-var-dart = " file://0005-imx8mm-Set-IMX_BOOT_UART_BASE-for-console-on-uart4.patch"
