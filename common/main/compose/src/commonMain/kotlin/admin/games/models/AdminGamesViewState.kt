package admin.games.models

import models.Game

data class AdminGamesViewState(
    val games: List<Game> = emptyList()
)
