package com.jmonzonm.rickmortyapp.ui.home.tabs.episodes

import androidx.paging.PagingData
import com.jmonzonm.rickmortyapp.domain.model.EpisodeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class EpisodesState(
    val episodes: Flow<PagingData<EpisodeModel>> = emptyFlow(),
    val playVideo: String = ""
)
