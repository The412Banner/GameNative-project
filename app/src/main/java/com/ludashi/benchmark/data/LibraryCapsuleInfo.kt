package com.ludashi.benchmark.data

import com.ludashi.benchmark.enums.Language
import kotlinx.serialization.Serializable

@Serializable
data class LibraryCapsuleInfo(
    val image: Map<Language, String> = emptyMap(),
    val image2x: Map<Language, String> = emptyMap(),
)
