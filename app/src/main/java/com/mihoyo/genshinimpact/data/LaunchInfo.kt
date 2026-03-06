package com.mihoyo.genshinimpact.data

import com.mihoyo.genshinimpact.db.serializers.OsEnumSetSerializer
import com.mihoyo.genshinimpact.enums.OS
import com.mihoyo.genshinimpact.enums.OSArch
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
