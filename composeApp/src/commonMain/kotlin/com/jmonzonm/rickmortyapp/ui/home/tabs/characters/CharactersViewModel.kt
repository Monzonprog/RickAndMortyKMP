package com.jmonzonm.rickmortyapp.ui.home.tabs.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.jmonzonm.rickmortyapp.domain.GetAllCharactersUseCase
import com.jmonzonm.rickmortyapp.domain.GetRandomCharacterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class CharactersViewModel(
    private val getRandomCharacter: GetRandomCharacterUseCase,
    private val getAllCharactersUseCase: GetAllCharactersUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<CharactersState>(CharactersState())
    val state: StateFlow<CharactersState> = _state

    init {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                getRandomCharacter()
            }
            _state.update { it.copy(characterOfTheDay = result) }
            getAllCharacters()
        }
    }

    private suspend fun getAllCharacters() {
        _state.update { state -> state.copy(characters = getAllCharactersUseCase().cachedIn(viewModelScope)) }
    }
}