package com.example.nammavastra_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val editCost = findViewById<EditText>(R.id.editCost)
        val btnCalc = findViewById<Button>(R.id.btnCalc)
        val result = findViewById<TextView>(R.id.result)

        btnCalc.setOnClickListener {
            val costText = editCost.text.toString()

            if (costText.isNotEmpty()) {
                val cost = costText.toDouble()
                val price = cost + (cost * 0.3)
                result.text = "Selling Price: ₹$price"
            } else {
                result.text = "Please enter cost"
            }
        }
    }
}