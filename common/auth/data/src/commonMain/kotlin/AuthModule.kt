import ktor.KtorAuthRemoteDataSource
import org.koin.dsl.module
import settings.SettingsAuthDataSource

val authModule = module {

    single<AuthRepository> {
        AuthRepositoryImpl(get(), get())
    }

    factory {
        SettingsAuthDataSource(get())
    }

    factory {
        KtorAuthRemoteDataSource(get())
    }
}