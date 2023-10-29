import ktor.KtorAuthRemoteDataSource
import ktor.KtorLoginRequest
import models.Token
import settings.SettingsAuthDataSource

class AuthRepositoryImpl(
    private val remoteDataSource: KtorAuthRemoteDataSource,
    private val cashedDataSource: SettingsAuthDataSource
) : AuthRepository {
    override suspend fun login(login: String, password: String): Token {
        val token = remoteDataSource.performLogin(
            request = KtorLoginRequest(
                login = login,
                password = password
            )
        )
        cashedDataSource.saveToken(token.token)
        return token
    }

    override fun isUserLoggedIn(): Boolean {
        //return cashedDataSource.fetchToken().isNotBlank()
        return true
    }
}