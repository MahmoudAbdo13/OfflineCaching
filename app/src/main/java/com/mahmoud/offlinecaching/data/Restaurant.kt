package com.mahmoud.offlinecaching.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "restaurants")
data class Restaurant(
    @PrimaryKey val id:Int,
    val name:String,
    val logo:String,
    val type:String,
    val address:String
)