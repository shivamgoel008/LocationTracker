package com.example.googlemaps.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.googlemaps.R
import com.example.googlemaps.data.GoogleM
import kotlinx.android.synthetic.main.activity_list_google_m.*

class ListGoogleM : AppCompatActivity() , IGoogleMAdapter {

    private lateinit var viewModel: ListGoogleMViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_google_m)

        recyclerView.layoutManager=LinearLayoutManager(this)
        val adapter=GoogleMAdapter(this,this)
        recyclerView.adapter=adapter

        viewModel=ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(ListGoogleMViewModel::class.java)
        viewModel.allGoogleM.observe(this, Observer { list->
            list?.let {
                adapter.updateList(it)
            }
        })
    }

    override fun onItemClicked(googleM: GoogleM) {
    }


}