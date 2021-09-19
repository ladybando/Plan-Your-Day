package com.example.planyourday

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.*
import androidx.navigation.findNavController
import androidx.navigation.navArgs
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.planyourday.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    //val navController = findNavController(R.id.nav_host_fragment)

    private lateinit var binding: ActivityMainBinding
    val args: SafeVarargs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listOfTasks = mutableListOf<Task>()
        val adapter = Adapter(listOfTasks)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Display current user date in textView
        val dateDisplay: TextView = findViewById(R.id.date)
        dateDisplay.text = SimpleDateFormat("EEEE, MMMM dd, yyyy").format(Date())

        binding.addButton.setOnClickListener {
            val stringForTask = findViewById<EditText>(R.id.task).text.toString()
            listOfTasks.add(Task(stringForTask)).toString()
            binding.task.getText().clear()

            adapter.notifyDataSetChanged()
        }


        // Swipe to delete
        val swipeToDeleteCallBack = object : SwipeToDeleteCallBack() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                listOfTasks.removeAt(position)
                adapter.notifyItemRemoved(position)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallBack)
        itemTouchHelper.attachToRecyclerView(binding.recyclerView)


    }
}
