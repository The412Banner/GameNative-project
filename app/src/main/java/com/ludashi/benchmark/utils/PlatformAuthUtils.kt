package com.ludashi.benchmark.utils

import android.content.Context
import com.ludashi.benchmark.service.SteamService
import com.ludashi.benchmark.service.amazon.AmazonService
import com.ludashi.benchmark.service.epic.EpicService
import com.ludashi.benchmark.service.gog.GOGService

object PlatformAuthUtils {
    fun isSignedInToAnyPlatform(context: Context): Boolean =
        SteamService.isLoggedIn ||
        GOGService.hasStoredCredentials(context) ||
        EpicService.hasStoredCredentials(context) ||
        AmazonService.hasStoredCredentials(context)
}
