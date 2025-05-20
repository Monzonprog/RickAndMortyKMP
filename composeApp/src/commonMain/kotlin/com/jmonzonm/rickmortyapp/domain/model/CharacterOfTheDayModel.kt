package com.jmonzonm.rickmortyapp.domain.model

import com.jmonzonm.rickmortyapp.data.database.entity.CharacterOfTheDayEntity
import kotlinx.serialization.json.Json

data class CharacterOfTheDayModel(
    val characterModel: CharacterModel,
    val selectedDay: String
) {
    fun toEntity(): CharacterOfTheDayEntity {
        return CharacterOfTheDayEntity(
            id = characterModel.id,
            name = characterModel.name,
            image = characterModel.image,
            isAlive = characterModel.isAlive,
            selectedDay = selectedDay,
            species = characterModel.species,
            gender = characterModel.gender,
            origin = characterModel.origin,
            episodes = Json.encodeToString(characterModel.episodes)
        )
    }
}
