package com.jmonzonm.rickmortyapp.data.remote.response

import kotlinx.serialization.Serializable

@Serializable
data class InfoResponse(
    val count: Int,
    val pages: Int,
    val next: String?,
    val prev: String?

)