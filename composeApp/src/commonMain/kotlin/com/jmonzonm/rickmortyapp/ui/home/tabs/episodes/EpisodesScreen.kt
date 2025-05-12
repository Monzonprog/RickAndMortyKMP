package com.jmonzonm.rickmortyapp.ui.home.tabs.episodes

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import app.cash.paging.compose.collectAsLazyPagingItems
import com.jmonzonm.rickmortyapp.domain.model.EpisodeModel
import com.jmonzonm.rickmortyapp.domain.model.SeasonEpisode
import com.jmonzonm.rickmortyapp.domain.model.SeasonEpisode.SEASON_1
import com.jmonzonm.rickmortyapp.domain.model.SeasonEpisode.SEASON_2
import com.jmonzonm.rickmortyapp.domain.model.SeasonEpisode.SEASON_3
import com.jmonzonm.rickmortyapp.domain.model.SeasonEpisode.SEASON_4
import com.jmonzonm.rickmortyapp.domain.model.SeasonEpisode.SEASON_5
import com.jmonzonm.rickmortyapp.domain.model.SeasonEpisode.SEASON_6
import com.jmonzonm.rickmortyapp.domain.model.SeasonEpisode.SEASON_7
import com.jmonzonm.rickmortyapp.domain.model.SeasonEpisode.UNKNOWN
import com.jmonzonm.rickmortyapp.ui.core.components.PagingLoadingState
import com.jmonzonm.rickmortyapp.ui.core.components.PagingType
import com.jmonzonm.rickmortyapp.ui.core.components.PagingWrapper
import com.jmonzonm.rickmortyapp.ui.core.components.VideoPlayer
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import rickmortyapp.composeapp.generated.resources.Res
import rickmortyapp.composeapp.generated.resources.portal
import rickmortyapp.composeapp.generated.resources.season1
import rickmortyapp.composeapp.generated.resources.season2
import rickmortyapp.composeapp.generated.resources.season3
import rickmortyapp.composeapp.generated.resources.season4
import rickmortyapp.composeapp.generated.resources.season5
import rickmortyapp.composeapp.generated.resources.season6
import rickmortyapp.composeapp.generated.resources.season7

@OptIn(KoinExperimentalAPI::class)
@Composable
fun EpisodesScreen() {
    val episodesViewModel = koinViewModel<EpisodesViewModel>()
    val state by episodesViewModel.state.collectAsState()
    val episodes = state.episodes.collectAsLazyPagingItems()

    Column(Modifier.fillMaxSize()) {
        PagingWrapper(
            pagingType = PagingType.ROW,
            pagingItems = episodes,
            initialView = {
                PagingLoadingState()
            },
            itemView = { EpisodeItemList(it) { url -> episodesViewModel.onPlaySelected(url) } }
        )
        EpisodePlayer(state.playVideo){episodesViewModel.onCloseVideo()}
    }
}

@Composable
fun EpisodePlayer(playVideo: String, onCloseVideo: () -> Unit){
    AnimatedVisibility (playVideo.isNotBlank()) {
        ElevatedCard(
            modifier = Modifier.fillMaxWidth().height(250.dp).padding(16.dp)
                .border(3.dp, color = Color.Green, shape = CardDefaults.elevatedShape)
        ) {
            Box(modifier = Modifier.background(Color.Black)) {
                Box(modifier = Modifier.padding(16.dp), contentAlignment = Alignment.Center) {
                    VideoPlayer(
                        modifier = Modifier.fillMaxWidth().height(200.dp),
                        url = playVideo
                    )
                }
                Row {
                    Spacer(modifier = Modifier.weight(1f))
                    Image(
                        painter = painterResource(Res.drawable.portal),
                        contentDescription = "",
                        modifier = Modifier.padding(8.dp).size(40.dp).clickable {
                            onCloseVideo()
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun EpisodeItemList(episode: EpisodeModel, onEpisodeSelected: (String) -> Unit) {
    Column(
        modifier = Modifier.width(120.dp).padding(horizontal = 8.dp)
            .clickable { onEpisodeSelected(episode.videoURL) }) {
        Image(
            modifier = Modifier.height(200.dp).fillMaxWidth(),
            contentDescription = "",
            contentScale = ContentScale.Inside,
            painter = painterResource(getSeasonImage(episode.season))
        )
    }
}

fun getSeasonImage(seasonEpisode: SeasonEpisode): DrawableResource {
    return when (seasonEpisode) {
        SEASON_1 -> Res.drawable.season1
        SEASON_2 -> Res.drawable.season2
        SEASON_3 -> Res.drawable.season3
        SEASON_4 -> Res.drawable.season4
        SEASON_5 -> Res.drawable.season5
        SEASON_6 -> Res.drawable.season6
        SEASON_7 -> Res.drawable.season7
        UNKNOWN -> Res.drawable.season1
    }
}