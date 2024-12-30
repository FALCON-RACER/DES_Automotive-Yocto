#include <QtCore/QUrl>
#include <QtCore/QDebug>

#include <QtGui/QGuiApplication>

#include <QtQml/QQmlApplicationEngine>

#include <QDebug>
#include <QScreen>

int main(int argc, char *argv[])
{
    // AA_ShareOpenGLContexts is required for compositors with multiple outputs
    QCoreApplication::setAttribute(Qt::AA_ShareOpenGLContexts, true);
    QGuiApplication app(argc, argv);

    const auto screens = QGuiApplication::screens();
    qDebug() << "screen 0: " << screens[0]->name();
    qDebug() << "screen 1: " << screens[1]->name();

    QQmlApplicationEngine appEngine(QUrl("qrc:///qml/main.qml"));

    return app.exec();
}
