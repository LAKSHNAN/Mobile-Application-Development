package com.example.scientificcalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    private lateinit var tvDisplay: TextView

    private var current = ""
    private var operand = 0.0
    private var operator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDisplay = findViewById(R.id.tvDisplay)

        // Number buttons
        val numIds = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6,
            R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btnDot
        )

        for (id in numIds) {
            findViewById<Button>(id).setOnClickListener {
                current += (it as Button).text.toString()
                tvDisplay.text = current
            }
        }

        // Operators
        setOperator(R.id.btnAdd, "+")
        setOperator(R.id.btnSub, "-")
        setOperator(R.id.btnMul, "*")
        setOperator(R.id.btnDiv, "/")

        // Equal
        findViewById<Button>(R.id.btnEqual).setOnClickListener {
            val num2 = current.toDoubleOrNull() ?: return@setOnClickListener
            val result = when (operator) {
                "+" -> operand + num2
                "-" -> operand - num2
                "*" -> operand * num2
                "/" -> operand / num2
                else -> num2
            }
            tvDisplay.text = result.toString()
            current = result.toString()
        }

        // Clear
        findViewById<Button>(R.id.btnClear).setOnClickListener {
            current = ""
            operand = 0.0
            tvDisplay.text = "0"
        }

        // Scientific functions
        findViewById<Button>(R.id.btnSin).setOnClickListener { apply { sin(Math.toRadians(it)) } }
        findViewById<Button>(R.id.btnCos).setOnClickListener { apply { cos(Math.toRadians(it)) } }
        findViewById<Button>(R.id.btnTan).setOnClickListener { apply { tan(Math.toRadians(it)) } }
        findViewById<Button>(R.id.btnLog).setOnClickListener { apply { log10(it) } }
        findViewById<Button>(R.id.btnSqrt).setOnClickListener { apply { sqrt(it) } }
    }

    private fun setOperator(id: Int, op: String) {
        findViewById<Button>(id).setOnClickListener {
            operand = current.toDoubleOrNull() ?: 0.0
            operator = op
            current = ""
        }
    }

    private fun apply(func: (Double) -> Double) {
        val value = current.toDoubleOrNull() ?: return
        val result = func(value)
        tvDisplay.text = result.toString()
        current = result.toString()
    }
}