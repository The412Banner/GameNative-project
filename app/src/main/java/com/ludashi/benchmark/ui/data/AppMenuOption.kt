package com.ludashi.benchmark.ui.data

import com.ludashi.benchmark.ui.enums.AppOptionMenuType

data class AppMenuOption(
    val optionType: AppOptionMenuType,
    val onClick: () -> Unit,
)
