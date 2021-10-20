package com.meetsuccess.roomdatabasekotling

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "contact")
data class contact (
        @PrimaryKey(autoGenerate = true)
    val id:Long,
    val name:String,
    val phone:String,
        val date: Date
        ,val active:Int

)