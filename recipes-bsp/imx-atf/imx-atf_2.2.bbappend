FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " file://imx8m-Disable-ATF-console_imx_uart_register-for.patch"
SRC_URI_append = " file://imx8m-atf-ddr-timing.patch"
SRC_URI_append_imx8mm-var-dart = " file://imx8mm-atf-uart4.patch"
SRC_URI_append_imx8mn-var-som  = " file://imx8mn-atf-uart4.patch"

# SRC_URI_append_imx8mq-var-dart = " file://0001-MLK-24457-plat-imx8m-Fix-the-current-fsp-init.patch"
# SRC_URI_append_imx8mq-var-dart = " file://0001-MLK-24502-plat-imx8m-Add-mem-repair-done-check-for-d.patch"
# SRC_URI_append_imx8mq-var-dart = " file://0001-MLK-24721-plat-imx8m-Fix-the-out-of-bound-access-to-.patch"
SRC_URI_append_imx8mq-var-dart = " file://0001-imx8mq-Enable-ATF-Console.patch"

SRCBRANCH = "imx_5.4.47_2.2.0"
ATF_SRC ?= "git://source.codeaurora.org/external/imx/imx-atf.git;protocol=https"
SRC_URI = "${ATF_SRC};branch=${SRCBRANCH} \
"
SRCREV = "c949a888e909811db191500c51456391dff61284"
