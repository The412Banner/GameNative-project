package com.tencent.ig.utils

import android.content.Context
import com.tencent.ig.service.SteamService
import com.tencent.ig.service.amazon.AmazonService
import com.tencent.ig.service.epic.EpicService
import com.tencent.ig.service.gog.GOGService

object PlatformAuthUtils {
    fun isSignedInToAnyPlatform(context: Context): Boolean =
        SteamService.isLoggedIn ||
        GOGService.hasStoredCredentials(context) ||
        EpicService.hasStoredCredentials(context) ||
        AmazonService.hasStoredCredentials(context)
}
