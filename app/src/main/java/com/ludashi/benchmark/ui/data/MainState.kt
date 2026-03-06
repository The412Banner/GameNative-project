package com.ludashi.benchmark.ui.data

import com.ludashi.benchmark.enums.AppTheme
import com.ludashi.benchmark.ui.enums.ConnectionState
import com.ludashi.benchmark.ui.screen.PluviaScreen
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
