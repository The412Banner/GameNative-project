package com.mihoyo.genshinimpact.db.converters

import androidx.room.TypeConverter
import com.mihoyo.genshinimpact.enums.PathType

class PathTypeConverter {
    @TypeConverter
    fun fromPathType(pathType: PathType): String = pathType.name

    @TypeConverter
    fun toPathType(value: String): PathType = PathType.from(value)
}
