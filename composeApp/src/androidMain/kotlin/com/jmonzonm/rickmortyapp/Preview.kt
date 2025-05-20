package com.jmonzonm.rickmortyapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.jmonzonm.rickmortyapp.domain.model.CharacterModel
import com.jmonzonm.rickmortyapp.ui.home.tabs.characters.CharacterOfTheDay

@Composable
@Preview
fun preview(){
    CharacterOfTheDay(
        CharacterModel(
            id = 3,
            image = "https://rickandmortyapi.com/api/character/avatar/11.jpeg",
            name = "Prueba",
            isAlive = true,
            species = "Humano"
        )
    )
}