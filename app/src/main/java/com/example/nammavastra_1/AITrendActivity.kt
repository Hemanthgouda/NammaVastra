package com.example.nammavastra_1

import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class AITrendActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var txtResult: TextView

    private var selectedImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ai_trend)

        val btnSelectImage =
            findViewById<Button>(R.id.btnSelectImage)

        val btnAnalyze =
            findViewById<Button>(R.id.btnAnalyze)

        imageView = findViewById(R.id.imageView)
        txtResult = findViewById(R.id.txtResult)

        // Image Picker

        val imagePicker = registerForActivityResult(
            ActivityResultContracts.GetContent()
        ) { uri ->

            if (uri != null) {

                selectedImageUri = uri
                imageView.setImageURI(uri)
            }
        }

        btnSelectImage.setOnClickListener {

            imagePicker.launch("image/*")
        }

        // AI Analyze

        btnAnalyze.setOnClickListener {

            if (selectedImageUri == null) {

                txtResult.text =
                    "Please upload saree image first"

                return@setOnClickListener
            }

            generateAITrend()
        }
    }

    // Local AI Trend Generator

    private fun generateAITrend() {

        val aiResult = """

AI Saree Trend Analysis

• Trending Style:
Minimalist silk and pastel sarees are trending.

• Customer Preference:
Urban customers prefer lightweight elegant designs.

• Suggested Improvement:
Add modern silver zari borders and soft color combinations.

• Suitable Market:
Wedding collections and festive boutiques.

• Fashion Trend:
Traditional handloom designs with modern styling are highly popular.

• Estimated Demand:
High demand among young customers.

        """.trimIndent()

        txtResult.text = aiResult
    }
}