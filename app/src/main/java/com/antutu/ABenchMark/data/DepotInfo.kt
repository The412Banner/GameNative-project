package com.antutu.ABenchMark.data

import com.antutu.ABenchMark.db.serializers.OsEnumSetSerializer
import com.antutu.ABenchMark.enums.OS
import com.antutu.ABenchMark.enums.OSArch
import com.antutu.ABenchMark.service.SteamService
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
