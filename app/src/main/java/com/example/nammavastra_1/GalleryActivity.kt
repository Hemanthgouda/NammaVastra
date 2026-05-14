package com.example.nammavastra_1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class GalleryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_gallery)

        val btnWhatsapp1 = findViewById<Button>(R.id.btnWhatsapp1)
        val btnWhatsapp2 = findViewById<Button>(R.id.btnWhatsapp2)

        // First Saree WhatsApp Inquiry

        btnWhatsapp1.setOnClickListener {

            val message = "Hello, I am interested in the Pastel Silk Saree."

            openWhatsApp(message)
        }

        // Second Saree WhatsApp Inquiry

        btnWhatsapp2.setOnClickListener {

            val message = "Hello, I am interested in the Wedding Designer Saree."

            openWhatsApp(message)
        }
    }

    private fun openWhatsApp(message: String) {

        val phoneNumber = "916362401687"

        val url =
            "https://wa.me/$phoneNumber?text=${Uri.encode(message)}"

        val intent = Intent(Intent.ACTION_VIEW)

        intent.data = Uri.parse(url)

        startActivity(intent)
    }
}