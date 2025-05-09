package com.jmonzonm.rickmortyapp.domain

import androidx.paging.PagingData
import com.jmonzonm.rickmortyapp.data.database.entity.CharacterOfTheDayEntity
import com.jmonzonm.rickmortyapp.domain.model.CharacterModel
import com.jmonzonm.rickmortyapp.domain.model.CharacterOfTheDayModel
import com.jmonzonm.rickmortyapp.domain.model.EpisodeModel
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getSingleCharacter(id: String): CharacterModel
    fun getAllCharacters(): Flow<PagingData<CharacterModel>>
    suspend fun getCharacterDB(): CharacterOfTheDayModel?
    suspend fun saveCharacterDB(characterOfTheDayModel: CharacterOfTheDayModel)
    suspend fun getAllEpisodes(): Flow<PagingData<EpisodeModel>>
}