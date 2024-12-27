cmake_minimum_required(VERSION 3.5)

project(WaylandLayerManager VERSION 0.1 LANGUAGES CXX)

set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED ON)
set(CMAKE_AUTOMOC ON)

find_package(Qt6 COMPONENTS Quick Core Gui WaylandCompositor REQUIRED)

qt_add_executable(wayland-layer-manager
    main.cpp
    resources.qrc
)

qt_add_resources(wayland-layer-manager
    PREFIX "/"
    FILES
        qml/main.qml
	qml/CompositorScreen.qml
)

# Qt for iOS sets MACOSX_BUNDLE_GUI_IDENTIFIER automatically since Qt 6.1.
# If you are developing for iOS or macOS you should consider setting an
# explicit, fixed bundle identifier manually though.
set_target_properties(wayland-layer-manager PROPERTIES
#    MACOSX_BUNDLE_GUI_IDENTIFIER com.example.apptestwayland
    MACOSX_BUNDLE_BUNDLE_VERSION ${PROJECT_VERSION}
    MACOSX_BUNDLE_SHORT_VERSION_STRING ${PROJECT_VERSION_MAJOR}.${PROJECT_VERSION_MINOR}
    MACOSX_BUNDLE TRUE
    WIN32_EXECUTABLE TRUE
)

target_link_libraries(wayland-layer-manager
    PRIVATE Qt6::Core Qt6::Gui Qt6::WaylandCompositor
)

include(GNUInstallDirs)
install(TARGETS wayland-layer-manager
    BUNDLE DESTINATION .
    LIBRARY DESTINATION ${CMAKE_INSTALL_LIBDIR}
    RUNTIME DESTINATION ${CMAKE_INSTALL_BINDIR}
)
