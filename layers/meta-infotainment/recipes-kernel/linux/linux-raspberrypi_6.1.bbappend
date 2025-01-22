LINUX_VERSION = "6.1.46"
SRCREV_machine = "e89e7655a197d28df49da2be7e2003436cf52197"
KERNEL_DEVICETREE:append = " \
	overlays/mcp251xfd.dtbo \
	overlays/vc4-kms-dsi-waveshare-panel.dtbo \
"
