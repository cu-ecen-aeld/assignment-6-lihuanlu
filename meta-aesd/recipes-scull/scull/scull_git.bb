# Update to run action runner.
# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f098732a73b5f6f3430472f5b094ffdb"

SRC_URI = "git://git@github.com/cu-ecen-aeld/assignment-7-lihuanlu.git;protocol=ssh;branch=main file://S98scull"

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "5492a3844a0bec0e97ff3dba5b8752bd41fd9400"

S = "${WORKDIR}/git"

inherit module update-rc.d

EXTRA_OEMAKE = " -C ${STAGING_KERNEL_DIR} M=${S}/scull EXTRA_CFLAGS='-I${S}/include'"

INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME:${PN} = "S98scull"

FILES:${PN} += "${sysconfdir}/init.d/S98scull"

do_install:append () {
    install -d ${D}/lib/modules/${KERNEL_VERSION}/extra
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/S98scull ${D}${sysconfdir}/init.d
}
