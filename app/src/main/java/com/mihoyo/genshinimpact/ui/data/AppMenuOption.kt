package com.mihoyo.genshinimpact.ui.data

import com.mihoyo.genshinimpact.ui.enums.AppOptionMenuType

data class AppMenuOption(
    val optionType: AppOptionMenuType,
    val onClick: () -> Unit,
)
