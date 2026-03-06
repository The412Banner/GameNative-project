package com.ludashi.benchmark.ui.data

import com.ludashi.benchmark.PrefManager
import com.ludashi.benchmark.ui.enums.HomeDestination

data class HomeState(
    val currentDestination: HomeDestination = PrefManager.startScreen,
    val confirmExit: Boolean = false,
)
