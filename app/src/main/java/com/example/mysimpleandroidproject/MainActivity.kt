package com.example.mysimpleandroidproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var rvMusic: RecyclerView
    private val list = ArrayList<Music>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvMusic = findViewById(R.id.rv_music)
        rvMusic.setHasFixedSize(true)

        list.addAll(getListMusic())
        showRecyclerList()

        val btnMoveActivity: Button = findViewById(R.id.about_page)
        btnMoveActivity.setOnClickListener(this)
    }

    private fun getListMusic(): ArrayList<Music> {
        val dataTitle = resources.getStringArray(R.array.music_title_list)
        val dataArtist = resources.getStringArray(R.array.music_artist_list)
        val dataImage = resources.getStringArray(R.array.music_photo_list)
        val dataYear = resources.getStringArray(R.array.music_release_year_list)
        val link = resources.getStringArray(R.array.music_link_list)
        val link2 = resources.getStringArray(R.array.music_spotify_list)
        val lyrics = resources.getStringArray(R.array.music_lyrics_list)
        val views_amount = resources.getStringArray(R.array.listen_amount)
        val listMusic = ArrayList<Music>()
        for (i in dataTitle.indices) {
            val music = Music(dataTitle[i], dataArtist[i], dataYear[i], dataImage[i], link[i], lyrics[i], link2[i], views_amount[i])
            listMusic.add(music)
        }
        return listMusic
    }

    private fun showRecyclerList() {
        rvMusic.layoutManager = LinearLayoutManager(this)
        val listMusicAdapterAdapter = ListMusicAdapter(list)
        rvMusic.adapter = listMusicAdapterAdapter
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.about_page -> {
                val moveIntent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }
}
