ENABLE_SPI_BUS = "1"
ENABLE_I2C = "1"

do_deploy:append() { 
    echo "hdmi_safe=1" >> $CONFIG
    echo "dtparam=i2c_arm=on" >> $CONFIG
    echo "dtoverlay=spi1-3cs" >> $CONFIG
    echo "dtoverlay=spi0-3cs" >> $CONFIG
    echo "dtoverlay=mcp251xfd,spi0-0,interrupt=25" >> $CONFIG
    echo "dtoverlay=mcp251xfd,spi1-0,interrupt=24" >> $CONFIG

    echo "camera_auto_detect=1" >> $CONFIG

    echo "display_auto_detect=1" >> $CONFIG

    echo "dtoverlay=vc4-kms-v3d-pi4" >> $CONFIG
    echo "dtoverlay=vc4-kms-dsi-waveshare-panel,7_9_inch" >> $CONFIG

    echo "# Disable compensation for displays with overscan" >> $CONFIG
    echo "disable_overscan=1" >> $CONFIG

    echo "dtparam=audio=on" >> $CONFIG
    echo "arm_bit64=1" >> $CONFIG

    echo "gpu_mem=512" >> $CONFIG
    echo "dtoverlay=dwc2,dr_mode=host" >> $CONFIG
    
    echo "disable_splash=1" >> $CONFIG
}


IMAGE_BOOT_FILES += "config.txt"

RPI_KERNEL_DEVICETREE_OVERLAYS:append = " overlays/vc4-kms-dsi-waveshare-panel.dtbo"
