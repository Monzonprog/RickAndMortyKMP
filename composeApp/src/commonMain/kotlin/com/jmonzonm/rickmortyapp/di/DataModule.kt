package com.jmonzonm.rickmortyapp.di

import com.jmonzonm.rickmortyapp.data.RepositoryImpl
import com.jmonzonm.rickmortyapp.data.remote.ApiService
import com.jmonzonm.rickmortyapp.data.remote.paging.CharactersPagingSource
import com.jmonzonm.rickmortyapp.data.remote.paging.EpisodesPagingSource
import com.jmonzonm.rickmortyapp.domain.Repository
import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.logging.SIMPLE
import io.ktor.http.ContentType
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val dataModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(json = Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
            }
            install(DefaultRequest) {
                url {
                    protocol = URLProtocol.HTTPS
                    host = "rickandmortyapi.com"
                    //parameters.append("key", "")
                }
            }
            install(Logging) {
                logger = Logger.SIMPLE
                level = LogLevel.ALL
            }
        }
    }

    factoryOf(::ApiService)
    factory<Repository> { RepositoryImpl(get(), get(), get(), get()) }
    factoryOf(::CharactersPagingSource)
    factoryOf(::EpisodesPagingSource)
}