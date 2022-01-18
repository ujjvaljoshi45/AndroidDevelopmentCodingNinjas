package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var num1:EditText
    lateinit var num2:EditText
    lateinit var result:TextView
    lateinit var add:Button
    lateinit var sub:Button
    lateinit var multiply:Button
    lateinit var divide:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        num1 = findViewById(R.id.et_number1)
        num2 = findViewById(R.id.et_number2)
        add = findViewById(R.id.add)
        sub = findViewById(R.id.subtract)
        multiply = findViewById(R.id.multiply)
        divide = findViewById(R.id.divide)
        result = findViewById(R.id.result)
        add.setOnClickListener(View.OnClickListener {
            val n1:Int = Integer.parseInt(num1.text.toString())
            val n2:Int = Integer.parseInt(num2.text.toString())
            AddNumbers(n1,n2)
        })
        sub.setOnClickListener(View.OnClickListener {
            val n1:Int = Integer.parseInt(num1.text.toString())
            val n2:Int = Integer.parseInt(num2.text.toString())
            SubNumbers(n1,n2)
        })
        multiply.setOnClickListener(View.OnClickListener {
            val n1:Int = Integer.parseInt(num1.text.toString())
            val n2:Int = Integer.parseInt(num2.text.toString())
            MultiplyNumbers(n1,n2)
        })
        divide.setOnClickListener(View.OnClickListener {
            val n1:Int = Integer.parseInt(num1.text.toString())
            val n2:Int = Integer.parseInt(num2.text.toString())
            DivideNumbers( n1,n2)
        })
    }
    fun AddNumbers(one:Int, two:Int){
        result.text = "Addition : ${one + two}"
    }
    fun SubNumbers(one:Int, two:Int){
        result.text = "Subtraction : ${one - two}"
    }
    fun MultiplyNumbers(one:Int, two:Int){
        result.text = "Multiplication : ${one * two}"
    }
    fun DivideNumbers(one:Int, two:Int){
        result.text = "Division : ${one / two}"
    }
}