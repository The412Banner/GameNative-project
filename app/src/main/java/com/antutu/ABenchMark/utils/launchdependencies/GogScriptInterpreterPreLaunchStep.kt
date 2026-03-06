package com.antutu.ABenchMark.utils.launchdependencies

import android.content.Context
import com.antutu.ABenchMark.data.GameSource
import com.antutu.ABenchMark.service.gog.GOGService
import com.winlator.container.Container
import com.winlator.xenvironment.components.GuestProgramLauncherComponent

/** Pre-launch step that runs GOG scriptinterpreter.exe when required by the game manifest. */
object GogScriptInterpreterPreLaunchStep : PreLaunchStep {
    override fun appliesTo(container: Container, appId: String, gameSource: GameSource): Boolean =
        gameSource == GameSource.GOG

    override fun run(
        context: Context,
        appId: String,
        container: Container,
        guestProgramLauncherComponent: GuestProgramLauncherComponent,
        gameSource: GameSource,
    ) {
        GOGService.runScriptInterpreterIfNeeded(appId, guestProgramLauncherComponent)
    }
}
