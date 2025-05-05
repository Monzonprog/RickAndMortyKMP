package com.jmonzonm.rickmortyapp.domain.model

import com.jmonzonm.rickmortyapp.data.database.entity.CharacterOfTheDayEntity

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
            selectedDay = selectedDay
        )
    }
}
