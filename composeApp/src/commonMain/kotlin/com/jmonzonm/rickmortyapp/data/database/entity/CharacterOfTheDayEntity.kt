package com.jmonzonm.rickmortyapp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characteroftheday")
data class CharacterOfTheDayEntity(
    @PrimaryKey
    val id: Int,
    val image: String,
    val name: String,
    val isAlive: Boolean,
    val selectedDate: String
)
