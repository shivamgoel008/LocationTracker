package com.example.googlemaps.ui

import android.content.Context
import android.location.LocationListener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.googlemaps.R
import com.example.googlemaps.data.GoogleM
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_item.view.*

class GoogleMAdapter(private val context: Context, private val listener: IGoogleMAdapter) :
    RecyclerView.Adapter<GoogleMAdapter.ViewHolder>() {
    private val getAllGoogleM = ArrayList<GoogleM>()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val longi = itemView.findViewById<TextView>(R.id.longitude_item)
        val lati = itemView.findViewById<TextView>(R.id.latitude_item)
        val datei = itemView.findViewById<TextView>(R.id.date_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val viewHolder =
            ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
//        viewHolder.deleteButton.setOnClickListener{
//            listener.onItemClicked(allNotes[viewHolder.adapterPosition])
//        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentGoogleM = getAllGoogleM[position]
        holder.longi.text = currentGoogleM.longitude
        holder.lati.text = currentGoogleM.latitude
        holder.datei.text = currentGoogleM.date
    }


    override fun getItemCount(): Int {
        if (getAllGoogleM.size > 0)
            return getAllGoogleM.size
        else
            return 0;
    }

    fun updateList(newList: List<GoogleM>) {
        getAllGoogleM.clear()
        getAllGoogleM.addAll(newList)

        notifyDataSetChanged()
    }
}

interface IGoogleMAdapter {
    fun onItemClicked(googleM: GoogleM)
}


