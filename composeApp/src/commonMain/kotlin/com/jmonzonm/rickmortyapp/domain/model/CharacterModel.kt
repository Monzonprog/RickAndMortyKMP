package com.jmonzonm.rickmortyapp.domain.model

data class CharacterModel(
    /*val created: String,
    val episode: List<String>,
    val gender: String,*/
    val id: Int,
    val image: String,
    val name: String,
   /* val location: Location,
    val origin: Origin,
    val species: String,*/
    val isAlive: Boolean,
    /*val type: String,
    val url: String*/
)

data class Origin(
    val name: String,
    val url: String
)

data class Location(
    val name: String,
    val url: String
)
