package com.jmonzonm.rickmortyapp.domain

class GetRandomCharacter(private val repository: Repository) {
    suspend fun invoke() {
        val random = (1..826)
        repository.getSingleCharacter(id = random.toString())
    }
}