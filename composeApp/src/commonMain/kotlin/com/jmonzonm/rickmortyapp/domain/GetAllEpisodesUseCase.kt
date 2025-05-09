package com.jmonzonm.rickmortyapp.domain

import androidx.paging.PagingData
import com.jmonzonm.rickmortyapp.domain.model.EpisodeModel
import kotlinx.coroutines.flow.Flow

class GetAllEpisodesUseCase(private val repository: Repository) {
    suspend operator fun invoke(): Flow<PagingData<EpisodeModel>> {
        return repository.getAllEpisodes()
    }
}