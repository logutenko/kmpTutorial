package sqldelight

import com.example.kmm.Database
import databases.GAMEDB
import ktor.models.KtorSearchGame

class SqlDelightGamesDataSource(
    private val database: Database
) {
    fun fetchLocalGames(): List<GAMEDB> {
        return database.gameQueries.getAllGames().executeAsList()
    }

    fun insertGame(game: KtorSearchGame) {
        database.gameQueries.inserGame(
            game_id = game.gameId,
            game_title = game.title,
            game_version = game.version,
            game_size = game.size
        )

    }
}