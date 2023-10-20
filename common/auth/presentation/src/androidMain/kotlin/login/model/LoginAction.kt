package login.model

sealed class LoginAction {
    object OpenRegistrationScreen : LoginAction()
    object OpenForgotPasswordScreen : LoginAction()
    object OpenMainFlow : LoginAction()
}