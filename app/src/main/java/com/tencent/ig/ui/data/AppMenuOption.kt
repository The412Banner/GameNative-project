package com.tencent.ig.ui.data

import com.tencent.ig.ui.enums.AppOptionMenuType

data class AppMenuOption(
    val optionType: AppOptionMenuType,
    val onClick: () -> Unit,
)
