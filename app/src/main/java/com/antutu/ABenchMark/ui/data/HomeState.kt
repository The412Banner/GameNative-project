package com.antutu.ABenchMark.ui.data

import com.antutu.ABenchMark.PrefManager
import com.antutu.ABenchMark.ui.enums.HomeDestination

data class HomeState(
    val currentDestination: HomeDestination = PrefManager.startScreen,
    val confirmExit: Boolean = false,
)
