package com.antutu.ABenchMark.utils

import android.content.Context
import com.antutu.ABenchMark.service.SteamService
import com.antutu.ABenchMark.service.amazon.AmazonService
import com.antutu.ABenchMark.service.epic.EpicService
import com.antutu.ABenchMark.service.gog.GOGService

object PlatformAuthUtils {
    fun isSignedInToAnyPlatform(context: Context): Boolean =
        SteamService.isLoggedIn ||
        GOGService.hasStoredCredentials(context) ||
        EpicService.hasStoredCredentials(context) ||
        AmazonService.hasStoredCredentials(context)
}
