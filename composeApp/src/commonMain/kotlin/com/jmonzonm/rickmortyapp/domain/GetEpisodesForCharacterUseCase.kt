package com.jmonzonm.rickmortyapp.domain

import com.jmonzonm.rickmortyapp.domain.model.EpisodeModel

class GetEpisodesForCharacterUseCase(private val repository: Repository) {
    suspend operator fun invoke(episodes: List<String>): List<EpisodeModel> {
        return repository.getEpisodesForCharacter(episodes = episodes)
    }
}