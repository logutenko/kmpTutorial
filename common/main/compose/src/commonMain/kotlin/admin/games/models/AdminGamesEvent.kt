package admin.games.models

sealed class AdminGamesEvent {
    object ViewInited : AdminGamesEvent()
    object AddGameClicked : AdminGamesEvent()
}
