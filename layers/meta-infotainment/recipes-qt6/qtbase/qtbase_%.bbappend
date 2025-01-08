PACKAGECONFIG:append = " opengl wayland"
PACKAGECONFIG[opengl] = "-opengl es2,,"
PACKAGECONFIG[wayland] = "-DFEATURE_wayland=ON,-DFEATURE_wayland=OFF,"
