package com.example.mysimpleandroidproject

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailMusic : AppCompatActivity() {

    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_music_layout)

        val receivedData = intent.getParcelableExtra<Music>("key_music")

        val titleTextView = findViewById<TextView>(R.id.title_music)
        val yearTextView = findViewById<TextView>(R.id.tahunRilis)
        val lyricsTextView = findViewById<TextView>(R.id.lyrics_view)
        val viewsTextView = findViewById<TextView>(R.id.textView16)
        val imageView = findViewById<ImageView>(R.id.imageView5)
        val artistView = findViewById<TextView>(R.id.artist_name)
        val ytButton = findViewById<ImageButton>(R.id.imageButton2)
        val sptfButton = findViewById<ImageButton>(R.id.imageButton)


        titleTextView.text = receivedData?.titles
        artistView.text = receivedData?.artist
        lyricsTextView.text = receivedData?.lyrics
        yearTextView.text = receivedData?.releaseyear
        viewsTextView.text = receivedData?.viewsamount


        Glide.with(this)
            .load(receivedData?.photo)
            .into(imageView)

        ytButton.setOnClickListener{
            val youtube = receivedData?.links

            if (!youtube.isNullOrEmpty()) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(youtube))
                startActivity(intent)
            } else{
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("youtube.com"))
                startActivity(intent)
            }
        }

        sptfButton.setOnClickListener{
            val spotify = receivedData?.linkspotify

            if (!spotify.isNullOrEmpty()) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(spotify))
                startActivity(intent)
            } else{
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("youtube.com"))
                startActivity(intent)
            }
        }
    }
}