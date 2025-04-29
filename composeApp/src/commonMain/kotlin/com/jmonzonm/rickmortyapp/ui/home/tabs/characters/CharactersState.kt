package com.jmonzonm.rickmortyapp.ui.home.tabs.characters

import com.jmonzonm.rickmortyapp.domain.model.CharacterModel

data class CharactersState(
    val characterOfTheDay: CharacterModel? = null
)
