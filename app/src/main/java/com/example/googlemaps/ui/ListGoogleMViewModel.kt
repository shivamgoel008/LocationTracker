package com.example.googlemaps.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.googlemaps.data.GoogleM
import com.example.googlemaps.data.GoogleMListRepository

class ListGoogleMViewModel(application: Application):AndroidViewModel(application) {
    private val repo:GoogleMListRepository= GoogleMListRepository(application)

    val allGoogleM:LiveData<List<GoogleM>>
    get()=repo.getGoogleM()
}