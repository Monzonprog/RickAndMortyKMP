package com.jmonzonm.rickmortyapp.domain

import androidx.paging.PagingData
import com.jmonzonm.rickmortyapp.domain.model.CharacterModel
import kotlinx.coroutines.flow.Flow

class GetAllCharactersUseCase(private val repository: Repository) {
    suspend operator fun invoke(): Flow<PagingData<CharacterModel>> {
        return repository.getAllCharacters()
    }
}