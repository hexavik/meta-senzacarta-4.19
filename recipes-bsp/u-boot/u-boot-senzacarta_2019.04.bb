# Copyright (C) 2019 SenzaCarta

SUMMARY = "U-Boot bootloader with support for SenzaCarta Board"

DESCRIPTION = "U-Boot bootloader with support for SenzaCarta Board. \
                Contact MAINTAINER for more support."

require u-boot-common.inc
require u-boot.inc
inherit pythonnative
inherit fsl-u-boot-localversion

PROVIDES += "u-boot"
DEPENDS_append = " python dtc-native"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

UBOOT_SRC ?= "git://github.com/en-vikrant/senzacarta-uboot-v2019.04.git;protocol=https"
SRCBRANCH = "master"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"
SRCREV = "0d171033a8367a2814372164c3e7bd3d582a23df"

S = "${WORKDIR}/git"

LOCALVERSION ?= "-4.19.35-1.1.0"

BOOT_TOOLS = "imx-boot-tools"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6|mx7|imx7dsenzacarta)"

UBOOT_NAME_mx6 = "u-boot-${MACHINE}.bin-${UBOOT_CONFIG}"
UBOOT_NAME_mx7 = "u-boot-${MACHINE}.bin-${UBOOT_CONFIG}"
UBOOT_NAME_imx7dsenzacarta = "u-boot-${MACHINE}.bin-${UBOOT_CONFIG}"
