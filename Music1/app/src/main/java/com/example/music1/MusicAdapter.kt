package com.example.music1

import android.media.MediaPlayer
import android.net.Uri
import android.provider.ContactsContract.Data
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.music1.databinding.ItemLayoutBinding
import java.text.SimpleDateFormat

class MusicAdapter : RecyclerView.Adapter<MusicAdapter.Holder>() {

    val musicList = mutableListOf<Music>()
    var mediaPlayer : MediaPlayer? = null


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

    inner class Holder(val binding : ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)    {

        var musicUri: Uri? = null

        init {
            itemView.setOnClickListener{
                if(mediaPlayer != null){
                    mediaPlayer?.release()
                    mediaPlayer = null
                }
                mediaPlayer= MediaPlayer.create(itemView.context, musicUri)
                mediaPlayer?.start()
            }
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

}


