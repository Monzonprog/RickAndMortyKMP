package com.jmonzonm.rickmortyapp.data.remote.response

import kotlinx.serialization.Serializable
import com.jmonzonm.rickmortyapp.domain.model.EpisodeModel
import com.jmonzonm.rickmortyapp.domain.model.SeasonEpisode
import com.jmonzonm.rickmortyapp.domain.model.SeasonEpisode.*

@Serializable
data class EpisodeResponse(
    val id: Int,
    val name: String,
    val episode: String,
    val characters: List<String>
) {
    fun toDomain(): EpisodeModel {
        val season = getSeasonFromEpisodeCode(episode)
        return EpisodeModel(
            id = id,
            name = name,
            episode = episode,
            characters = characters.map { url -> url.substringAfterLast("/") },
            season = season,
            videoURL = getVideoUrlFromSeason(season)
        )
    }

    private fun getSeasonFromEpisodeCode(episode: String): SeasonEpisode {
        return when {
            episode.startsWith("S01") -> SEASON_1
            episode.startsWith("S02") -> SEASON_2
            episode.startsWith("S03") -> SEASON_3
            episode.startsWith("S04") -> SEASON_4
            episode.startsWith("S05") -> SEASON_5
            episode.startsWith("S06") -> SEASON_6
            episode.startsWith("S07") -> SEASON_7
            else -> UNKNOWN
        }
    }

    private fun getVideoUrlFromSeason(season: SeasonEpisode): String {
        return when (season) {
            SEASON_1, SEASON_3, SEASON_5, SEASON_7 -> "https://firebasestorage.googleapis.com/v0/b/rickmortykmp-b4d37.firebasestorage.app/o/T1.mp4?alt=media&token=00031ad4-ba98-43ad-9a93-5061fd826941"
            SEASON_2, SEASON_4, SEASON_6 -> "https://firebasestorage.googleapis.com/v0/b/rickmortykmp-b4d37.firebasestorage.app/o/T2.mp4?alt=media&token=0b13f152-5522-46d7-815e-4da1a259b0e5"
            UNKNOWN -> ""
        }
    }
}
