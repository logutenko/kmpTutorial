import ktor.KtorGamesDataSource
import ktor.models.mapToGame
import models.CreateGameInfo
import models.Game
import sqldelight.SqlDelightGamesDataSource

class GamesRepositoryImpl(
    private val remoteDataSource: KtorGamesDataSource,
    private val localDataSource: SqlDelightGamesDataSource
) : GamesRepository {
    override suspend fun fetchAllGames(): List<Game> {
        return remoteDataSource.fetchAllGames().map { it.mapToGame() }
    }

    override suspend fun searchGame(query: String): List<Game> {
        return remoteDataSource.searchGame(query).map { it.mapToGame() }
    }

    override suspend fun createGame(token: String, info: CreateGameInfo) {
        return remoteDataSource.createGame(token, info)
    }
}