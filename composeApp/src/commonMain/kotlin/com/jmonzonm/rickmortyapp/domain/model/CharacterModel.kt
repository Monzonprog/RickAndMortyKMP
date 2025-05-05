package com.jmonzonm.rickmortyapp.domain.model

data class CharacterModel(
    val id: Int,
    val image: String,
    val name: String,
    val isAlive: Boolean,
)