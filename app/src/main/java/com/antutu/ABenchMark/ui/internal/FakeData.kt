package com.antutu.ABenchMark.ui.internal

import com.antutu.ABenchMark.BuildConfig
import com.antutu.ABenchMark.data.ConfigInfo
import com.antutu.ABenchMark.data.LibraryAssetsInfo
import com.antutu.ABenchMark.data.LibraryCapsuleInfo
import com.antutu.ABenchMark.data.LibraryHeroInfo
import com.antutu.ABenchMark.data.LibraryLogoInfo
import com.antutu.ABenchMark.data.SteamApp
import com.antutu.ABenchMark.data.UFS
import com.antutu.ABenchMark.enums.AppType
import com.antutu.ABenchMark.enums.ControllerSupport
import com.antutu.ABenchMark.enums.OS
import com.antutu.ABenchMark.enums.ReleaseState
import java.util.EnumSet

/**
 * Fata data for Compose previewing.
 */
internal fun fakeAppInfo(idx: Int): SteamApp {
    if (!BuildConfig.DEBUG) {
        throw RuntimeException("Fake app info shouldn't be used in release")
    }

    return SteamApp(
        id = 736260,
        // receiveIndex = 1,
        packageId = 112233,
        depots = mapOf(),
        branches = mapOf(),
        name = "Baba Is You $idx",
        type = AppType.game,
        osList = EnumSet.of(OS.windows, OS.macos, OS.linux),
        releaseState = ReleaseState.released,
        metacriticScore = 0,
        metacriticFullUrl = "",
        logoHash = "",
        logoSmallHash = "",
        iconHash = "",
        clientIconHash = "",
        clientTgaHash = "",
        smallCapsule = mapOf(),
        headerImage = mapOf(),
        libraryAssets = LibraryAssetsInfo(
            libraryCapsule = LibraryCapsuleInfo(image = mapOf(), image2x = mapOf()),
            libraryHero = LibraryHeroInfo(image = mapOf(), image2x = mapOf()),
            libraryLogo = LibraryLogoInfo(image = mapOf(), image2x = mapOf()),
        ),
        primaryGenre = false,
        reviewScore = 0,
        reviewPercentage = 0,
        controllerSupport = ControllerSupport.partial,
        demoOfAppId = 0,
        developer = "Hempuli Oy",
        publisher = "Hempuli Oy",
        homepageUrl = "",
        gameManualUrl = "",
        loadAllBeforeLaunch = false,
        dlcAppIds = emptyList(),
        isFreeApp = false,
        dlcForAppId = 0,
        mustOwnAppToPurchase = 0,
        dlcAvailableOnStore = false,
        optionalDlc = false,
        gameDir = "",
        installScript = "",
        noServers = false,
        order = false,
        primaryCache = 0,
        validOSList = EnumSet.of(OS.none),
        thirdPartyCdKey = false,
        visibleOnlyWhenInstalled = false,
        visibleOnlyWhenSubscribed = false,
        launchEulaUrl = "",
        requireDefaultInstallFolder = false,
        contentType = 0,
        installDir = "Baba Is You",
        useLaunchCmdLine = false,
        launchWithoutWorkshopUpdates = false,
        useMms = false,
        installScriptSignature = "",
        installScriptOverride = false,
        config = ConfigInfo(
            installDir = "Baba Is You",
            launch = emptyList(),
            steamControllerTemplateIndex = 4,
            steamControllerTouchTemplateIndex = 1,
        ),
        ufs = UFS(
            quota = 0,
            maxNumFiles = 0,
            saveFilePatterns = emptyList(),
        ),
    )
}
