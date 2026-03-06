package com.tencent.ig.db.converters

import androidx.room.TypeConverter
import com.tencent.ig.data.UserFileInfo
import kotlinx.serialization.json.Json

class UserFileInfoListConverter {
    @TypeConverter
    fun fromUserFileInfoList(userFileInfoList: List<UserFileInfo>?): String? = userFileInfoList?.let { Json.encodeToString(it) }

    @TypeConverter
    fun toUserFileInfoList(value: String?): List<UserFileInfo>? = value?.let { Json.decodeFromString<List<UserFileInfo>>(it) }
}
