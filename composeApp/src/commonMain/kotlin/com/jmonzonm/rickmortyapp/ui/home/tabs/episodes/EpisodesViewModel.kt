package com.jmonzonm.rickmortyapp.ui.home.tabs.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.jmonzonm.rickmortyapp.domain.GetAllEpisodesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class EpisodesViewModel(private val getAllEpisodesUseCase: GetAllEpisodesUseCase) : ViewModel() {

    private val _state = MutableStateFlow<EpisodesState>(EpisodesState())
    val state: StateFlow<EpisodesState> = _state

    init {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                getAllEpisodesUseCase().cachedIn(viewModelScope)
            }
            _state.update { it.copy(episodes = result) }
        }
    }

    fun onPlaySelected(url: String) {
        _state.update { state -> state.copy(playVideo = url) }
    }

    fun onCloseVideo() {
        _state.update { state -> state.copy(playVideo = "") }
    }
}