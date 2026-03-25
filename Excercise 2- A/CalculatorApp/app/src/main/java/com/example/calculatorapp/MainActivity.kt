package com.example.calculatorapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etValue1: EditText
    private lateinit var etValue2: EditText
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etValue1 = findViewById(R.id.etValue1)
        etValue2 = findViewById(R.id.etValue2)
        tvResult = findViewById(R.id.tvResult)

        val btnAdd: Button = findViewById(R.id.btnAdd)
        val btnSub: Button = findViewById(R.id.btnSub)
        val btnMul: Button = findViewById(R.id.btnMul)
        val btnDiv: Button = findViewById(R.id.btnDiv)
        val btnMod: Button = findViewById(R.id.btnMod)

        btnAdd.setOnClickListener { calculate("+") }
        btnSub.setOnClickListener { calculate("-") }
        btnMul.setOnClickListener { calculate("*") }
        btnDiv.setOnClickListener { calculate("/") }
        btnMod.setOnClickListener { calculate("%") }
    }

    private fun calculate(op: String) {
        val v1 = etValue1.text.toString()
        val v2 = etValue2.text.toString()

        if (v1.isEmpty() || v2.isEmpty()) {
            tvResult.text = "Enter values"
            return
        }

        val num1 = v1.toDouble()
        val num2 = v2.toDouble()

        val result = when (op) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> if (num2 != 0.0) num1 / num2 else "Error"
            "%" -> num1 % num2
            else -> "Invalid"
        }

        tvResult.text = result.toString()
    }
}