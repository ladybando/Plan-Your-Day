package com.example.planyourday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dateDisplay: TextView = findViewById(R.id.date)
        dateDisplay.text = SimpleDateFormat("EEEE, MMMM dd, yyyy").format(Date())

    }
}