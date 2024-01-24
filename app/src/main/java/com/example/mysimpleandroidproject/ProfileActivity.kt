package com.example.mysimpleandroidproject

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_layout)

        val backButton = findViewById<Button>(R.id.button_back)

        backButton.setOnClickListener(View.OnClickListener {
                onBackPressed()
            }
        )
    }
}