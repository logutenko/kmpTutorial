package login

import GamesRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject
import login.model.LoginAction
import login.model.LoginEvent
import login.model.LoginViewState

class LoginViewModel : BaseSharedViewModel<LoginViewState, LoginAction, LoginEvent>(
    initialState = LoginViewState(email = "", password = "")
) {
    private val gamesRepository: GamesRepository = Inject.instance()
    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is LoginEvent.EmailChanged -> obtainEmailChanged(viewEvent.value)
            is LoginEvent.ForgotClick -> openForgot()
            is LoginEvent.LoginClick -> sendLogin()
            is LoginEvent.PasswordChanged -> obtainPasswordChanged(viewEvent.value)
            is LoginEvent.RegistrationClick -> openRegistration()
        }
    }

    private fun sendLogin() {
        viewState = viewState.copy(isSending = true)
    }

    private fun openForgot() {
        viewAction = LoginAction.OpenForgotPasswordScreen
    }

    private fun openRegistration() {
        viewAction = LoginAction.OpenRegistrationScreen
    }

    private fun obtainEmailChanged(value: String) {
        viewState = viewState.copy(email = value)
    }

    private fun obtainPasswordChanged(value: String) {
        viewState = viewState.copy(password = value)
    }
}