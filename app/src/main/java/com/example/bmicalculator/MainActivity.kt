package com.example.bmicalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logIn = findViewById<View>(R.id.btnEnter)

        logIn.setOnClickListener {
            val intent = Intent(this, BMICalculation::class.java)
            val personName = findViewById<TextView>(R.id.txtName).text
            intent.putExtra("personName", personName.toString())
            startActivity(intent)
        }
    }
}