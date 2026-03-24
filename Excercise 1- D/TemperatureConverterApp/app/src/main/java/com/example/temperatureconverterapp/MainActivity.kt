package com.example.temperatureconverterapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etTemp: EditText
    private lateinit var rgFrom: RadioGroup
    private lateinit var rgTo: RadioGroup
    private lateinit var btnConvert: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etTemp = findViewById(R.id.etTemp)
        rgFrom = findViewById(R.id.rgFrom)
        rgTo = findViewById(R.id.rgTo)
        btnConvert = findViewById(R.id.btnConvert)
        tvResult = findViewById(R.id.tvResult)

        btnConvert.setOnClickListener {

            val tempStr = etTemp.text.toString()

            if (tempStr.isEmpty()) {
                Toast.makeText(this, "Enter temperature", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val fromId = rgFrom.checkedRadioButtonId
            val toId = rgTo.checkedRadioButtonId

            if (fromId == -1 || toId == -1) {
                Toast.makeText(this, "Select both units", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val temp = tempStr.toDouble()
            var result = 0.0

            // Convert input to Celsius first
            val tempInCelsius = when (fromId) {
                R.id.rbFromCelsius -> temp
                R.id.rbFromFahrenheit -> (temp - 32) * 5 / 9
                R.id.rbFromKelvin -> temp - 273.15
                else -> temp
            }

            // Convert Celsius to target unit
            result = when (toId) {
                R.id.rbToCelsius -> tempInCelsius
                R.id.rbToFahrenheit -> (tempInCelsius * 9 / 5) + 32
                R.id.rbToKelvin -> tempInCelsius + 273.15
                else -> tempInCelsius
            }

            tvResult.text = "Converted Value: %.2f".format(result)
        }
    }
}