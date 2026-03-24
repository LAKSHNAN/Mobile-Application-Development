package com.example.checkincheckout

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textViewCount: TextView
    private lateinit var btnCheckIn: Button
    private lateinit var btnCheckOut: Button

    private var count = 0  // Initial value

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewCount = findViewById(R.id.textViewCount)
        btnCheckIn = findViewById(R.id.btnCheckIn)
        btnCheckOut = findViewById(R.id.btnCheckOut)

        // Set initial value
        textViewCount.text = count.toString()

        // Check-In button (Increment)
        btnCheckIn.setOnClickListener {
            count++
            textViewCount.text = count.toString()
        }

        // Check-Out button (Decrement)
        btnCheckOut.setOnClickListener {
            count--
            textViewCount.text = count.toString()
        }
    }
}