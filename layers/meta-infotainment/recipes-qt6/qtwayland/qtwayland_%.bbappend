PACKAGECONFIG:append = " compositor"
PACKAGECONFIG[compositor] = "-DFEATURE_wayland_compositor=ON,-DFEATURE_wayland_compositor=OFF,"
