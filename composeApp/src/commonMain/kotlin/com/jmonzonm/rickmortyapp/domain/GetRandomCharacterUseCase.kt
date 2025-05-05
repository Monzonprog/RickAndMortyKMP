package com.jmonzonm.rickmortyapp.domain

import com.jmonzonm.rickmortyapp.domain.model.CharacterModel
import com.jmonzonm.rickmortyapp.domain.model.CharacterOfTheDayModel
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

class GetRandomCharacterUseCase(private val repository: Repository) {
    suspend operator fun invoke(): CharacterModel {
        val characterOfTheDay: CharacterOfTheDayModel? = repository.getCharacterDB()
        val selectedDay = getCurrentDayOfTheYear()

        return if (characterOfTheDay != null && characterOfTheDay.selectedDay == selectedDay) {
            characterOfTheDay.characterModel
        } else {
            val result = generateRandomCharacter()
            repository.saveCharacterDB(
                CharacterOfTheDayModel(
                    characterModel = result,
                    selectedDay = selectedDay
                )
            )
            result
        }
    }

    private suspend fun generateRandomCharacter(): CharacterModel {
        val random = (1..826).random()
        return repository.getSingleCharacter(id = random.toString())
    }

    private fun getCurrentDayOfTheYear(): String {
        val instant = Clock.System.now()
        val localTime = instant.toLocalDateTime(TimeZone.currentSystemDefault())
        return "${localTime.dayOfYear}${localTime.year}"
    }
}