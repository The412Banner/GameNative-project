package com.antutu.ABenchMark.utils

import android.content.Context
import com.antutu.ABenchMark.data.GameSource
import com.antutu.ABenchMark.utils.launchdependencies.GogScriptInterpreterPreLaunchStep
import com.antutu.ABenchMark.utils.launchdependencies.PreLaunchStep
import com.winlator.container.Container
import com.winlator.xenvironment.components.GuestProgramLauncherComponent
import timber.log.Timber

/**
 * Runs all pre-launch steps that apply to a container/app.
 * Each step is run in order; exceptions are caught and logged per step so one failure does not block others.
 */
class PreLaunchSteps {
    companion object {
        private val preLaunchSteps: List<PreLaunchStep> = listOf(
            GogScriptInterpreterPreLaunchStep,
        )
    }

    fun run(
        context: Context,
        appId: String,
        container: Container,
        guestProgramLauncherComponent: GuestProgramLauncherComponent,
        gameSource: GameSource,
    ) {
        for (step in preLaunchSteps) {
            if (!step.appliesTo(container, appId, gameSource)) continue
            try {
                step.run(context, appId, container, guestProgramLauncherComponent, gameSource)
            } catch (e: Exception) {
                Timber.tag("PreLaunchSteps").e(e, "Pre-launch step failed: ${step::class.simpleName}")
            }
        }
    }
}
