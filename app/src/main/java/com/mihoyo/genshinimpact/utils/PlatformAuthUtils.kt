package com.mihoyo.genshinimpact.utils

import android.content.Context
import com.mihoyo.genshinimpact.service.SteamService
import com.mihoyo.genshinimpact.service.amazon.AmazonService
import com.mihoyo.genshinimpact.service.epic.EpicService
import com.mihoyo.genshinimpact.service.gog.GOGService

object PlatformAuthUtils {
    fun isSignedInToAnyPlatform(context: Context): Boolean =
        SteamService.isLoggedIn ||
        GOGService.hasStoredCredentials(context) ||
        EpicService.hasStoredCredentials(context) ||
        AmazonService.hasStoredCredentials(context)
}
