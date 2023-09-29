import models.Game

interface GamesRepository {
    suspend fun fetchAllGames(): List<Game>
    suspend fun searchGame(query: String): Game
}