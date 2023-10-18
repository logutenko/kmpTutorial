package ktor

import io.ktor.client.HttpClient
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.client.request.request
import io.ktor.http.HttpMethod
import io.ktor.http.URLProtocol
import ktor.models.KtorSearchGame
import ktor.models.KtorSearchRequest
import models.Game

class KtorGamesDataSource(private val httpClient: HttpClient) {
    suspend fun fetchAllGames(): List<KtorSearchGame> {
        return httpClient.post {
            header("Bearer-Authorization", "2bac6ef1-ca6d-42ca-96f3-923c68e88eca")

            url {
                protocol = URLProtocol.HTTP
                host = "192.168.15.246"
                port = 8080
                path("games/search")
                body = KtorSearchRequest(searchQuery = "")
            }
        }
    }

    suspend fun searchGame(query: String): Game {
        return Game(gameId = "", title = "Dota 2")
    }
}