package com.example.googlemaps.ui

import android.app.Application
import androidx.lifecycle.*
import com.example.googlemaps.data.GoogleM
import com.example.googlemaps.data.GoogleMDetailRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel (application: Application):AndroidViewModel(application){
    private val repo:GoogleMDetailRepository= GoogleMDetailRepository(application)

    private val _googleMId=MutableLiveData<Long>(0)

    val googleMId:LiveData<Long>
    get()=_googleMId

    val googleM:LiveData<GoogleM> = Transformations.switchMap(_googleMId){id->
        repo.getGoogleM(id)
    }

    fun setGoogleMId(id:Long){
        if(_googleMId.value!=id){
            _googleMId.value=id
        }
    }

    fun saveGoogleM(googleM: GoogleM){
        viewModelScope.launch(Dispatchers.IO) {
            repo.insertGoogleM(googleM)
        }
    }

}