import SwiftUI
import shared

@main
struct iOSApp: App {
	var body: some Scene {
		WindowGroup {
			MyComposeView()
		}
	}
}

struct MyComposeView: UIViewControllerRepresentable {
	func makeUIViewController(context: Context) -> UIViewController {
		MyViewWrapperKt.createUIViewController()
	}

	func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
	}
}
