package com.example.bmicalculator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.bmicalculator.databinding.ActivityBMICalculationBinding

class BMICalculation : AppCompatActivity() {

    lateinit var binding: ActivityBMICalculationBinding
    var bmiValue: Double = 0.00
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBMICalculationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val personName = intent?.getStringExtra("personName")
        val tv = findViewById<TextView>(R.id.tvName)
        tv.setText(personName)
        val tvStatus = findViewById<TextView>(R.id.statusContent)

        if(savedInstanceState != null){
            bmiValue = savedInstanceState.getDouble("bmiValue")

            if(bmiValue != 0.0){
                val tvStatus = findViewById<TextView>(R.id.statusContent)
                tvStatus.setText(getStatus())
            }
        }

        binding.btnCalculate.setOnClickListener{
            calculateBMI()
            tvStatus.setText(getStatus())
        }
    }

    override fun onSaveInstanceState(outState:Bundle) {
        super.onSaveInstanceState(outState)

        outState.putDouble("bmiIndex", bmiValue)
    }

    fun calculateBMI() {
        val stringInTextField = binding.txtHeight.text.toString()
        val stringInTextField2 = binding.txtWeight.text.toString()
        val height = stringInTextField.toDouble()
        val weight = stringInTextField2.toDouble()

        var meterSquare = height * height
        bmiValue = weight / meterSquare
    }

    fun getStatus():String{

        if(bmiValue < 18.5)
           return "Underweight"
        else if(bmiValue <= 24.9)
           return "Normal weight"
        else if(bmiValue <= 29.9)
            return "Overweight"
        else if(bmiValue <= 34.9)
            return "Obesity Class I"
        else if(bmiValue <= 39.9)
            return "Obesity Class II"
        else
            return "Obesity Class III"
    }
}