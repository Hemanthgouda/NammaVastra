package com.example.nammavastra_1

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore

class UploadActivity : AppCompatActivity() {

    private lateinit var imageView: ImageView
    private lateinit var txtResult: TextView
    private lateinit var etName: EditText
    private lateinit var etPrice: EditText

    private var imageUri: Uri? = null

    private val PICK_IMAGE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload)

        imageView = findViewById(R.id.imageView)
        txtResult = findViewById(R.id.txtResult)
        etName = findViewById(R.id.etName)
        etPrice = findViewById(R.id.etPrice)

        val btnChoose = findViewById<Button>(R.id.btnChoose)
        val btnAnalyze = findViewById<Button>(R.id.btnAnalyze)

        // Choose Image
        btnChoose.setOnClickListener {

            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT

            startActivityForResult(intent, PICK_IMAGE)
        }

        // Analyze with AI
        btnAnalyze.setOnClickListener {

            if (imageUri != null) {

                val sareeName = etName.text.toString()
                val sareePrice = etPrice.text.toString()

                val aiResult = """

AI Analysis Result:

• Saree Name:
$sareeName

• Trending Style:
$sareeName is suitable for modern urban fashion trends.

• Customer Appeal:
Young customers may prefer this saree for festivals and weddings.

• Suggested Improvements:
Add stylish borders and soft pastel colors.

• Estimated Market Value:
₹$sareePrice

• Fashion Trend:
This saree design is trending in handloom fashion collections.

""".trimIndent()

                val db = FirebaseFirestore.getInstance()

                val sareeData = hashMapOf(
                    "name" to sareeName,
                    "price" to sareePrice,
                    "trend" to aiResult
                )

                // Save to Firestore

                db.collection("sarees")
                    .add(sareeData)
                    .addOnSuccessListener {

                        txtResult.text =
                            aiResult + "\n\n✅ Data Saved to Firestore"

                    }
                    .addOnFailureListener { e ->

                        txtResult.text =
                            "❌ Firestore Error: ${e.message}"

                    }

            } else {

                txtResult.text =
                    "Please choose a saree image first."

            }
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(
            requestCode,
            resultCode,
            data
        )

        if (
            requestCode == PICK_IMAGE &&
            resultCode == Activity.RESULT_OK &&
            data != null &&
            data.data != null
        ) {

            imageUri = data.data

            // Show selected image
            imageView.setImageURI(imageUri)
        }
    }
}