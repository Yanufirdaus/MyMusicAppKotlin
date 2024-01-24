package com.example.mysimpleandroidproject

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class ListMusicAdapter (private val listMusic: ArrayList<Music>) : RecyclerView.Adapter<ListMusicAdapter.ListViewHolder>() {



    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvTitle: TextView = itemView.findViewById(R.id.tv_music_name)
        val tvArtist: TextView = itemView.findViewById(R.id.tv_artist_name)
        val tvYear: TextView = itemView.findViewById(R.id.tv_release_year)
        val buttonPlay: Button = itemView.findViewById(R.id.button_play)
        val buttonDetail: Button = itemView.findViewById(R.id.button_detail)

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_music_layout, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listMusic.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (titles, release_year, artist, photo, links) = listMusic[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.imgPhoto)
        holder.tvTitle.text = titles
        holder.tvArtist.text = artist
        holder.tvYear.text = release_year

        holder.buttonPlay.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(links))
            it.context.startActivity(intent)
        }

        holder.buttonDetail.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailMusic::class.java)
            intentDetail.putExtra("key_music", listMusic[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}