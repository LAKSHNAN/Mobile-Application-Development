package com.example.scientificcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    private lateinit var tvDisplay: TextView
    private var currentInput = ""
    private var result = 0.0
    private var operator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDisplay = findViewById(R.id.tvDisplay)

        val buttons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6,
            R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btnDot
        )

        for (id in buttons) {
            findViewById<Button>(id).setOnClickListener {
                val value = (it as Button).text.toString()
                currentInput += value
                tvDisplay.text = currentInput
            }
        }

        // Operators
        setOperator(R.id.btnAdd, "+")
        setOperator(R.id.btnSub, "-")
        setOperator(R.id.btnMul, "×")
        setOperator(R.id.btnDiv, "/")

        // Equal
        findViewById<Button>(R.id.btnEqual).setOnClickListener {
            val num2 = currentInput.toDoubleOrNull() ?: return@setOnClickListener

            result = when (operator) {
                "+" -> result + num2
                "-" -> result - num2
                "×" -> result * num2
                "/" -> result / num2
                else -> num2
            }

            tvDisplay.text = result.toString()
            currentInput = ""
        }

        // Clear
        findViewById<Button>(R.id.btnClear).setOnClickListener {
            currentInput = ""
            result = 0.0
            tvDisplay.text = "0"
        }

        // Scientific Functions
        findViewById<Button>(R.id.btnSin).setOnClickListener { applyFunc { sin(Math.toRadians(it)) } }
        findViewById<Button>(R.id.btnCos).setOnClickListener { applyFunc { cos(Math.toRadians(it)) } }
        findViewById<Button>(R.id.btnTan).setOnClickListener { applyFunc { tan(Math.toRadians(it)) } }
        findViewById<Button>(R.id.btnLog).setOnClickListener { applyFunc { log10(it) } }
        findViewById<Button>(R.id.btnSqrt).setOnClickListener { applyFunc { sqrt(it) } }
    }

    private fun setOperator(id: Int, op: String) {
        findViewById<Button>(id).setOnClickListener {
            result = currentInput.toDoubleOrNull() ?: 0.0
            operator = op
            currentInput = ""
        }
    }

    private fun applyFunc(func: (Double) -> Double) {
        val value = currentInput.toDoubleOrNull() ?: return
        val res = func(value)
        tvDisplay.text = res.toString()
        currentInput = res.toString()
    }
}