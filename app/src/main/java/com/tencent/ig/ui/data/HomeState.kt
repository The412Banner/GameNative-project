package com.tencent.ig.ui.data

import com.tencent.ig.PrefManager
import com.tencent.ig.ui.enums.HomeDestination

data class HomeState(
    val currentDestination: HomeDestination = PrefManager.startScreen,
    val confirmExit: Boolean = false,
)
