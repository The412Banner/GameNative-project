package com.antutu.ABenchMark.data

import com.antutu.ABenchMark.db.serializers.OsEnumSetSerializer
import com.antutu.ABenchMark.enums.OS
import com.antutu.ABenchMark.enums.OSArch
import java.util.EnumSet
import kotlinx.serialization.Serializable

@Serializable
data class LaunchInfo(
    val executable: String,
    val workingDir: String,
    val description: String,
    val type: String,
    @Serializable(with = OsEnumSetSerializer::class)
    val configOS: EnumSet<OS>,
    val configArch: OSArch,
)
