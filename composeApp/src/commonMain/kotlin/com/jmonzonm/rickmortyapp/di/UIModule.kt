package com.jmonzonm.rickmortyapp.di

import com.jmonzonm.rickmortyapp.ui.home.tabs.characters.CharactersViewModel
import com.jmonzonm.rickmortyapp.ui.home.tabs.episodes.EpisodesViewModel
import com.jmonzonm.rickmortyapp.ui.detail.CharacterDetailViewModel
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::EpisodesViewModel)
    viewModelOf(::CharactersViewModel)
    viewModelOf(::CharacterDetailViewModel)
}