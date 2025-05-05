package com.jmonzonm.rickmortyapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.jmonzonm.rickmortyapp.domain.model.CharacterModel
import com.jmonzonm.rickmortyapp.domain.model.CharacterOfTheDayModel

@Entity(tableName = "characteroftheday")
data class CharacterOfTheDayEntity(
    @PrimaryKey
    val id: Int,
    val image: String,
    val name: String,
    val isAlive: Boolean,
    val selectedDay: String
) {
    fun toDomain(): CharacterOfTheDayModel {
        return CharacterOfTheDayModel(
            characterModel =
                CharacterModel(id = id, isAlive = isAlive, image = image, name = name),
            selectedDay = selectedDay
        )
    }
}
