FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append = " file://imx8m-Disable-ATF-console_imx_uart_register-for.patch"
SRC_URI_append = " file://imx8m-atf-ddr-timing.patch"
SRC_URI_append_imx8mm-var-dart = " file://imx8mm-atf-uart4.patch"
SRC_URI_append_imx8mn-var-som  = " file://imx8mn-atf-uart4.patch"

SRC_URI_append_imx8mq-var-dart = " file://0001-MLK-24457-plat-imx8m-Fix-the-current-fsp-init.patch"
SRC_URI_append_imx8mq-var-dart = " file://0001-MLK-24721-plat-imx8m-Fix-the-out-of-bound-access-to-.patch"
SRC_URI_append_imx8mq-var-dart = " file://imx8m-Revert-plat-imx8m-use-non-fast-wakeup-stop-mode-for-.patch"
