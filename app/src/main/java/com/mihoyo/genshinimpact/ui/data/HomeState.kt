package com.mihoyo.genshinimpact.ui.data

import com.mihoyo.genshinimpact.PrefManager
import com.mihoyo.genshinimpact.ui.enums.HomeDestination

data class HomeState(
    val currentDestination: HomeDestination = PrefManager.startScreen,
    val confirmExit: Boolean = false,
)
