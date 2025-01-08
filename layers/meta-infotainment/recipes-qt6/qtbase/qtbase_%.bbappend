PACKAGECONFIG:append = " opengl wayland"
PACKAGECONFIG[opengl] = "-DFEATURE_opengl=ON -DEGLFS_OPENGL_ES2_ONLY=ON,,"
PACKAGECONFIG[wayland] = "-DFEATURE_wayland=ON,-DFEATURE_wayland=OFF,"
