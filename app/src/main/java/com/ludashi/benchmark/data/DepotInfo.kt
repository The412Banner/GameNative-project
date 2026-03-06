package com.ludashi.benchmark.data

import com.ludashi.benchmark.db.serializers.OsEnumSetSerializer
import com.ludashi.benchmark.enums.OS
import com.ludashi.benchmark.enums.OSArch
import com.ludashi.benchmark.service.SteamService
import java.util.EnumSet
import kotlinx.serialization.Serializable

@Serializable
data class DepotInfo(
    val depotId: Int,
    val dlcAppId: Int,
    val optionalDlcId: Int = SteamService.INVALID_APP_ID,
    val depotFromApp: Int,
    val sharedInstall: Boolean,
    @Serializable(with = OsEnumSetSerializer::class)
    val osList: EnumSet<OS>,
    val osArch: OSArch,
    val manifests: Map<String, ManifestInfo>,
    val encryptedManifests: Map<String, ManifestInfo>,
    val language: String = "",
    val realm: String = "",
)
