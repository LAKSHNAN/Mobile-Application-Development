package com.example.guicomponents

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var btnTextSize: Button
    private lateinit var btnTextColor: Button
    private lateinit var btnBgColor: Button

    // Text sizes cycle: 10, 15, 20, 25, 5, 10...
    private val textSizes = arrayOf(10f, 15f, 20f, 25f, 5f)
    private var sizeIndex = 0

    // Text colors cycle: Red, Blue, Green
    private val textColors = arrayOf(Color.RED, Color.BLUE, Color.GREEN)
    private var textColorIndex = 0

    // Background colors cycle: Yellow, Cyan, Magenta
    private val bgColors = arrayOf(Color.YELLOW, Color.CYAN, Color.MAGENTA)
    private var bgColorIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        btnTextSize = findViewById(R.id.btnTextSize)
        btnTextColor = findViewById(R.id.btnTextColor)
        btnBgColor = findViewById(R.id.btnBgColor)

        // Change Text Size
        btnTextSize.setOnClickListener {
            textView.textSize = textSizes[sizeIndex]
            sizeIndex = (sizeIndex + 1) % textSizes.size
        }

        // Change Text Color
        btnTextColor.setOnClickListener {
            textView.setTextColor(textColors[textColorIndex])
            textColorIndex = (textColorIndex + 1) % textColors.size
        }

        // Change Background Color
        btnBgColor.setOnClickListener {
            textView.setBackgroundColor(bgColors[bgColorIndex])
            bgColorIndex = (bgColorIndex + 1) % bgColors.size
        }
    }
}