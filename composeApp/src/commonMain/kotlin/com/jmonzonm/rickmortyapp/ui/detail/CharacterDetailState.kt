package com.jmonzonm.rickmortyapp.ui.detail

import com.jmonzonm.rickmortyapp.domain.model.CharacterModel
import com.jmonzonm.rickmortyapp.domain.model.EpisodeModel

data class CharacterDetailState(
    val characterModel: CharacterModel,
    val episodes: List<EpisodeModel>? = null
)
