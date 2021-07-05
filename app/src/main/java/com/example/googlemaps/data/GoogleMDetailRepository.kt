package com.example.googlemaps.data

import android.app.Application
import androidx.lifecycle.LiveData

class GoogleMDetailRepository(context:Application) {
    private val googleMDetailDao: GoogleMDetailDao =
        GoogleMDatabase.getDatabase(context).gooleMDetailDao()

    fun getGoogleM(id: Long): LiveData<GoogleM> {
        return googleMDetailDao.getGoogleM(id)
    }

    suspend fun insertGoogleM(googleM: GoogleM):Long{
        return googleMDetailDao.insertGoogleM(googleM)
    }

    suspend fun updateGoogleM(googleM: GoogleM){
        googleMDetailDao.updateGoogleM(googleM)
    }
}