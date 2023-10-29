package navigation

object NavigationTree {
    enum class Splash {
        Splash
    }

    enum class Auth {
        AuthFlow, Login, Register, Forgot
    }

    enum class Main {
        Dashboard, Home, Search, Events, Videos, Profile
    }
}