package com.example.googlemaps.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query

@Dao
interface GoogleMListDao {

    @Query("SELECT * FROM googlem order by id")
    fun getGoogleM(): LiveData<List<GoogleM>>

}