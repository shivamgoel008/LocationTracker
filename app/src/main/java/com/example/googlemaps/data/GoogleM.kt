package com.example.googlemaps.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "googlem")
data class GoogleM(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val longitude :String,
    val latitude :String,
    val date:String
)