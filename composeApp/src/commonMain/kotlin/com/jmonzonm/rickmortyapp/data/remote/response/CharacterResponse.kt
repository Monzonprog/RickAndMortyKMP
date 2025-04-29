package com.jmonzonm.rickmortyapp.data.remote.response

import com.jmonzonm.rickmortyapp.domain.model.CharacterModel
import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    /*val created: String,
    val episode: List<String>,
    val gender: String,*/
    val id: Int,
    val image: String,
    val name: String,
    /*val location: Location,
    val origin: Origin,
    val species: String,*/
    val status: String,
    /*val type: String,
    val url: String*/
) {
    fun toDomain(): CharacterModel {
        return CharacterModel(
            id = id,
            image = image,
            name = name,
            isAlive = status.lowercase() == "alive"
        )
    }
}

@Serializable
data class Origin(
    val name: String,
    val url: String
)

@Serializable
data class Location(
    val name: String,
    val url: String
)