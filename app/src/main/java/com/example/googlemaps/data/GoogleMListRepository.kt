package com.example.googlemaps.data

import android.app.Application
import androidx.lifecycle.LiveData

class GoogleMListRepository(context:Application) {

    private val googleMListDao:GoogleMListDao=GoogleMDatabase.getDatabase(context).googleMListDao()

    fun getGoogleM():LiveData<List<GoogleM>>{
        return googleMListDao.getGoogleM()
    }
}