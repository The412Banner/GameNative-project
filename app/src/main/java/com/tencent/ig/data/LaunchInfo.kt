package com.tencent.ig.data

import com.tencent.ig.db.serializers.OsEnumSetSerializer
import com.tencent.ig.enums.OS
import com.tencent.ig.enums.OSArch
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
