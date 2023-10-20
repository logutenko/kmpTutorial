package login.model

data class LoginViewState(
    val email: String,
    val password: String,
    val isSending: Boolean = false
)