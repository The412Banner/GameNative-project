package com.mihoyo.genshinimpact.data

import com.mihoyo.genshinimpact.enums.Language
import kotlinx.serialization.Serializable

@Serializable
data class LibraryHeroInfo(
    val image: Map<Language, String> = emptyMap(),
    val image2x: Map<Language, String> = emptyMap(),
)
