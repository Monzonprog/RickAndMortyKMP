package com.jmonzonm.rickmortyapp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CharacterModel(
    val id: Int,
    val image: String,
    val name: String,
    val isAlive: Boolean,
)