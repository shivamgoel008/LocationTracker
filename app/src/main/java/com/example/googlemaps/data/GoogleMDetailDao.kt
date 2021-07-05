package com.example.googlemaps.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GoogleMDetailDao {

    @Query("SELECT*FROM `googlem` WHERE `id`=:id")
    fun getGoogleM(id: Long): LiveData<GoogleM>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertGoogleM(googleM: GoogleM): Long

    @Update
    suspend fun updateGoogleM(googleM: GoogleM)
}