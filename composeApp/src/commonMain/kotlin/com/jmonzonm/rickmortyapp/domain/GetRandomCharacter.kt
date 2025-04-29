package com.jmonzonm.rickmortyapp.domain

import com.jmonzonm.rickmortyapp.domain.model.CharacterModel

class GetRandomCharacter(private val repository: Repository) {
    suspend operator fun invoke(): CharacterModel {
        val random = (1..826).random()
        return repository.getSingleCharacter(id = random.toString())
    }
}