# Copyright (C) 2019 SenzaCarta
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel provided and supported by SenzaCarta"
DESCRIPTION = "Linux Kernel for SenzaCarta Board. Contact \
				MAINTAINER for more details."

require recipes-kernel/linux/linux-imx.inc

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
DEPENDS += "lzop-native bc-native"

SRCBRANCH = "warrior"
LOCALVERSION = "-senzacarta"
KERNEL_SRC ?= "https://github.com/en-vikrant/linux-senzacarta.git;protocol=https"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH} \
			file://defconfig"
SRCREV = "9b12336745ad27b75417195ca8629d463b449690"

S = "${WORKDIR}/git"

DEFAULT_PREFERENCE = "1"

DEFCONFIG     = "defconfig"
DEFCONFIG_mx6 = "imx_v7_defconfig"
DEFCONFIG_mx7 = "imx_v7_defconfig"
DEFCONFIG_imx7dsenzacarta = "imx_v7_defconfig"

do_preconfigure_prepend() {
    # meta-freescale/classes/fsl-kernel-localversion.bbclass requires
    # defconfig in ${WORKDIR}
    install -d ${B}
    cp ${S}/arch/${ARCH}/configs/${DEFCONFIG} ${WORKDIR}/defconfig
}

COMPATIBLE_MACHINE = "(mx6|mx7|imx7dsenzacarta)"
