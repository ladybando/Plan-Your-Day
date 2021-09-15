package com.example.planyourday

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.planyourday.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listOfTasks = mutableListOf<Task>()
        val adapter = Adapter(listOfTasks)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        val dateDisplay: TextView = findViewById(R.id.date)
        dateDisplay.text = SimpleDateFormat("EEEE, MMMM dd, yyyy").format(Date())

        binding.addButton.setOnClickListener {
            val stringForTask = findViewById<EditText>(R.id.task).text.toString()
            listOfTasks.add(Task(stringForTask)).toString()
            binding.task.getText().clear()

            adapter.notifyDataSetChanged()
        }

        // Swipe to delete


    }
}