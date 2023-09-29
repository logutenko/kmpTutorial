import org.kodein.di.DI

val umbrellaModule = DI.Module("umbrella") {
    importAll(
        coreModule,
        gamesModule
    )
}