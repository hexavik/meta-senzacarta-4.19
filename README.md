# meta-senzacarta

SenzaCarta Yocto Project for V3

# How to compile and use software for SenzaCarta

Here you will find some basic info about how to start with YOCTO and SenzaCarta. If you follow the steps below, you should be able to compile the source code.

In case you would like to know more about YOCTO and How to use it, for example: How to create, modify, compile and use meta-senzacarta. Please contact the MAINTAINER of the board Vikrant A. P. <vikrant.ap@econote.in>

### 1) Install the repo utility
	$ mkdir ~/bin
	$ curl https://storage.googleapis.com/git-repo-downloads/repo > ~/bin/repo
	$ chmod a+x ~/bin/repo
	$ PATH=${PATH}:~/bin

### 2) Get the YOCTO Project
	$ cd
	$ mkdir imx-yocto-bsp
	$ cd imx-yocto-bsp
	$ repo init -u https://source.codeaurora.org/external/imx/imx-manifest -b imx-linux-warrior -m imx-4.19.35-1.1.0.xml

### 3) Add SenzaCarta support - Create manifest
	$ cd ~/imx-yocto-bsp/
	$ mkdir -pv .repo/local_manifests/

Copy and Paste this into your Linux host machine

	$ cat > .repo/local_manifests/imx7dsenzacarta.xml << EOF
	<?xml version="1.0" encoding="UTF-8"?>
	<manifest>
		<remote fetch="git://github.com/en-vikrant" name="en-vikrant"/>
		<project remote="en-vikrant" revision="master" name="meta-senzacarta" path="sources/meta-senzacarta">
			<copyfile src="senzacarta-setup.sh" dest="senzacarta-setup.sh"/>
		</project>
	</manifest>
	EOF

### 4) Sync repositories
	$ repo sync

### 5) Add SenzaCarta meta layer into BSP
	$ source senzacarta-setup.sh

# Building Images
	$ cd ~/imx-yocto-bsp/
	$ repo sync

### Currently Supported machines <machine name>
Here is a list of 'machine names' which you can use to build SenzaCarta images. Use the 'machine name' based on the board you have:

	imx7dsenzacarta

### Setup and Build Console image
	$ MACHINE=imx7dsenzacarta source setup-environment build-sc
	$ MACHINE=imx7dsenzacarta bitbake core-image-base

### Setup and Build Toolchain
	$ MACHINE=imx7dsenzacarta bitbake core-image-base -c populate_sdk

All repositories regarding U-boot and Linux Kernel maintained separately by SenzaCarta Team
