package com.example.music1

import android.net.Uri
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.music1.databinding.ItemLayoutBinding
import java.text.SimpleDateFormat

class MusicAdapter : RecyclerView.Adapter<Holder>() {

    val musicList = mutableListOf<Music>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemLayoutBinding
            .inflate(LayoutInflater.from(parent.context),parent,false)
        //LayoutInflater.from(parent.context)
//            .inflate(R.layout.item_layout, parent, false)
        return Holder(binding)

    }


    override fun getItemCount(): Int{
        return musicList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val music = musicList[position]
        holder.setMusic(music)
    }

}


class Holder(val binding : ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)    {

    var musicUri: Uri? = null

    init {
        
    }


    fun setMusic(music:Music){
        musicUri = music.getMusicUri()
        binding.imageAlbum.setImageURI(music.getMusicUri())
        binding.textArtist.text = music.artist
        binding.textTItle.text = music.title
        val sdf = SimpleDateFormat("mm:ss")
        binding.textDuration.text= sdf.format(music.duration)




    }

}