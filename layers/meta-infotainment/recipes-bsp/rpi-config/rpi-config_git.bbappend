ENABLE_SPI_BUS = "1"
ENABLE_I2C = "1"


do_deploy:append() { 
    echo #"hdmi_safe=1" >> $CONFIG
    echo "dtparam=i2c_arm=on" >> $CONFIG
    echo "dtoverlay=spi1-3cs" >> $CONFIG
    echo "dtoverlay=spi0-3cs" >> $CONFIG
    echo "dtoverlay=mcp251xfd,spi0-0,interrupt=25" >> $CONFIG
    echo "dtoverlay=mcp251xfd,spi1-0,interrupt=24" >> $CONFIG

    echo "# Automatically load overlays for detected DSI displays" >> $CONFIG
    echo "display_auto_detect=1" >> $CONFIG

    echo "# Enable DRM VC4 V3D driver" >> $CONFIG
    echo "dtoverlay=vc4-kms-v3d-pi4" >> $CONFIG
    echo "dtoverlay=vc4-kms-dsi-waveshare-panel,7_9_inch" >> $CONFIG

    echo "# Disable compensation for displays with overscan" >> $CONFIG
    echo "disable_overscan=1" >> $CONFIG

    echo "arm_bit64=1" >> $CONFIG
    echo "# Gpu configuration" >> $CONFIG
    echo "gpu_mem_256=256" >> $CONFIG
    echo "#dtoverlay=dwc2,dr_mode=host" >> $CONFIG
    
    echo "disable_splash=1" >> $CONFIG
}


IMAGE_BOOT_FILES += "config.txt"
