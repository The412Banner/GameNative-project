package com.antutu.ABenchMark.ui.data

import com.antutu.ABenchMark.enums.AppTheme
import com.antutu.ABenchMark.ui.enums.ConnectionState
import com.antutu.ABenchMark.ui.screen.PluviaScreen
import com.materialkolor.PaletteStyle

data class MainState(
    val appTheme: AppTheme = AppTheme.NIGHT,
    val paletteStyle: PaletteStyle = PaletteStyle.TonalSpot,
    val resettedScreen: PluviaScreen? = null,
    val currentScreen: PluviaScreen? = PluviaScreen.LoginUser,
    val hasLaunched: Boolean = false,
    val loadingDialogVisible: Boolean = false,
    val loadingDialogProgress: Float = 0F,
    val loadingDialogMessage: String = "Loading...",
    val annoyingDialogShown: Boolean = false,
    val hasCrashedLastStart: Boolean = false,
    val isSteamConnected: Boolean = false,
    val launchedAppId: String = "",
    val bootToContainer: Boolean = false,
    val testGraphics: Boolean = false,
    val showBootingSplash: Boolean = false,
    val bootingSplashText: String = "Booting...",

    // Connection state for background reconnection
    // Default to DISCONNECTED - service will start and set to CONNECTING
    val connectionState: ConnectionState = ConnectionState.DISCONNECTED,
    val connectionMessage: String? = null,
    val connectionTimeoutSeconds: Int = 0,
)
