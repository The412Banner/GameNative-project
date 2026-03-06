package com.mihoyo.genshinimpact.gamefixes

import android.content.Context
import com.mihoyo.genshinimpact.data.GameSource

interface GameFix {
    fun apply(
        context: Context,
        gameId: String,
        installPath: String,
        installPathWindows: String,
    ): Boolean
}

/**
 * A [GameFix] that declares its registry key (source + id) so the registry
 * can build the map automatically without repeating the id.
 */
interface KeyedGameFix : GameFix {
    val gameSource: GameSource
    val gameId: String
}
