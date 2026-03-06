package com.ludashi.benchmark.db.converters

import androidx.room.TypeConverter
import com.ludashi.benchmark.enums.PathType

class PathTypeConverter {
    @TypeConverter
    fun fromPathType(pathType: PathType): String = pathType.name

    @TypeConverter
    fun toPathType(value: String): PathType = PathType.from(value)
}
