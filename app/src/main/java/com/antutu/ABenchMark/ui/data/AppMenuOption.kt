package com.antutu.ABenchMark.ui.data

import com.antutu.ABenchMark.ui.enums.AppOptionMenuType

data class AppMenuOption(
    val optionType: AppOptionMenuType,
    val onClick: () -> Unit,
)
