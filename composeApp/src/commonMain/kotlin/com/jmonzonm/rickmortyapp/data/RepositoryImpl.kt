package com.jmonzonm.rickmortyapp.data

import com.jmonzonm.rickmortyapp.data.remote.ApiService
import com.jmonzonm.rickmortyapp.domain.Repository
import com.jmonzonm.rickmortyapp.domain.model.CharacterModel

class RepositoryImpl(private val api: ApiService): Repository {
    override suspend fun getSingleCharacter(id: String): CharacterModel {
        return api.getSingleCharacter(id = id).toDomain()
    }
}