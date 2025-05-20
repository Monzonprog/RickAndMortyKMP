package com.jmonzonm.rickmortyapp.data.remote.response

import com.jmonzonm.rickmortyapp.domain.model.CharacterModel
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
    val gender: String,
    val origin: OriginResponse,
    val episode: List<String>
) {
    fun toDomain(): CharacterModel {
        return CharacterModel(
            id = id,
            image = image,
            name = name,
            isAlive = status.lowercase() == "alive",
            species = species,
            gender = gender,
            origin = origin.name,
            episodes = episode.map { it.substringAfter("/") }
        )
    }
}