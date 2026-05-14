package com.example.nammavastra_1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Buttons
        val btnStory = findViewById<Button>(R.id.btnStory)
        val btnUpload =
            findViewById<Button>(R.id.btnUpload)

        val btnGallery =
            findViewById<Button>(R.id.btnGallery)

        val btnCalculator =
            findViewById<Button>(R.id.btnCalculator)

        val btnAI =
            findViewById<Button>(R.id.btnAI)

        // Upload Screen

        btnUpload.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    UploadActivity::class.java
                )
            )
        }

        // Gallery Screen

        btnGallery.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    GalleryActivity::class.java
                )
            )
        }

        // Calculator Screen

        btnCalculator.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    CalculatorActivity::class.java
                )
            )
        }

        // AI Trend Screen

        btnAI.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    AITrendActivity::class.java
                )
            )
        }
        btnStory.setOnClickListener {

            val intent =
                Intent(this, WeaverStoryActivity::class.java)

            startActivity(intent)
        }
    }
}