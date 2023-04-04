package com.example.music1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MusicAdapter : RecyclerView.Adapter<Holder>() {

    val musicList = mutableListOf<Music>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return Holder(view)

    }

    override fun getItemCount(): Int{
        return musicList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val music = musicList[position]
        holder.setMusic(music)
    }

}


class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)    {


    fun setMusic(music:Music){
//        itemView.

    }

}