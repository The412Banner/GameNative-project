package com.tencent.ig.gamefixes

import com.tencent.ig.data.GameSource

val STEAM_Fix_22330: KeyedGameFix = KeyedRegistryKeyFix(
    gameSource = GameSource.STEAM,
    gameId = "22330",
    registryKey = "Software\\Wow6432Node\\Bethesda Softworks\\Oblivion",
    defaultValues = mapOf(
        "Installed Path" to INSTALL_PATH_PLACEHOLDER,
    ),
)
