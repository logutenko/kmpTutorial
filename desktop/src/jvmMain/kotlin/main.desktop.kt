import platform.PlatformConfiguration
import setup.setupThemedNavigation
import javax.swing.JFrame
import javax.swing.SwingUtilities

fun main() = SwingUtilities.invokeLater {
    PlatformSDK.initKoin(
        configuration = PlatformConfiguration()
    )

    JFrame().setupThemedNavigation()
}