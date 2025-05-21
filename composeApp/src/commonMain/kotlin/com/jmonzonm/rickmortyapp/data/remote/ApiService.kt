package com.jmonzonm.rickmortyapp.data.remote

import com.jmonzonm.rickmortyapp.data.remote.response.CharacterResponse
import com.jmonzonm.rickmortyapp.data.remote.response.CharactersWrapperResponse
import com.jmonzonm.rickmortyapp.data.remote.response.EpisodeResponse
import com.jmonzonm.rickmortyapp.data.remote.response.EpisodesWrappersResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class ApiService(private val client: HttpClient) {
    suspend fun getSingleCharacter(id: String): CharacterResponse {
        return client.get(urlString = "/api/character/$id").body()
    }

    suspend fun getAllCharacters(page: Int): CharactersWrapperResponse {
        return client.get(urlString = "/api/character/") {
            parameter("page", page)
        }.body()
    }

    suspend fun getAllEpisodes(page: Int): EpisodesWrappersResponse {
        return client.get(urlString = "/api/episode") {
            parameter("page", page)
        }.body()
    }

    suspend fun getEpisodes(episodes: String): List<EpisodeResponse> {
        return client.get("/api/episode/$episodes").body()
    }

    suspend fun getSingleEpisode(episode: String): EpisodeResponse {
        return client.get("/api/episode/$episode").body()
    }
}