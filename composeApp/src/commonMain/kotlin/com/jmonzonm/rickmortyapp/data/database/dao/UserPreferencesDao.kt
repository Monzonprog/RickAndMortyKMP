package com.jmonzonm.rickmortyapp.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.jmonzonm.rickmortyapp.data.database.entity.CharacterOfTheDayEntity

@Dao
interface UserPreferencesDao {
    @Query("SELECT * FROM characteroftheday")
    suspend fun getCharacterOfTheDayDB(): CharacterOfTheDayEntity?
}