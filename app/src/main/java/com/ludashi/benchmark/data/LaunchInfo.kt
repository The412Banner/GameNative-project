package com.ludashi.benchmark.data

import com.ludashi.benchmark.db.serializers.OsEnumSetSerializer
import com.ludashi.benchmark.enums.OS
import com.ludashi.benchmark.enums.OSArch
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
