package com.meetsuccess.roomdatabasekotling

import androidx.room.TypeConverter
import java.util.*

class converter {
    @TypeConverter
    fun longToDate(long: Long): Date {
        return Date(long)

    }
    @TypeConverter
    fun DateToLong(date: Date): Long {
        return date.time

    }
}