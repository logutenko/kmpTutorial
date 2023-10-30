package admin.creategame.model

sealed class CreateGameAction {
    object CloseScreen : CreateGameAction()
}