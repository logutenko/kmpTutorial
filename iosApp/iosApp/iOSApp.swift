import SwiftUI
import SharedSDK

@main
struct iOSApp: App {
    
    init() {
        PlatformSDK().doInitKoin(configuration: PlatformConfiguration())
    }
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
