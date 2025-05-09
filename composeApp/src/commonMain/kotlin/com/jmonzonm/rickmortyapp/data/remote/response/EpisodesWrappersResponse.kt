package com.jmonzonm.rickmortyapp.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class EpisodesWrappersResponse(
    val info: InfoResponse,
    val result: List<EpisodeResponse>
)
