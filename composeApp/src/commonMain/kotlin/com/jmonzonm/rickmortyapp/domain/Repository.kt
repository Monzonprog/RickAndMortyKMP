package com.jmonzonm.rickmortyapp.domain

import com.jmonzonm.rickmortyapp.domain.model.CharacterModel

interface Repository {
    suspend fun getSingleCharacter(id: String): CharacterModel
}