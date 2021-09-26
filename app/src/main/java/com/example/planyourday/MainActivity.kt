package com.example.planyourday

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.planyourday.adapter.Adapter
import com.example.planyourday.databinding.ActivityMainBinding
import com.example.planyourday.databinding.FragmentAddTaskBinding
import com.example.planyourday.databinding.FragmentListViewBinding
import com.example.planyourday.databinding.ItemLayoutBinding
import com.example.planyourday.model.Task
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    private lateinit var binding: ActivityMainBinding
    private lateinit var itemLayoutBinding: ItemLayoutBinding
    private lateinit var listViewBinding: FragmentListViewBinding
    private lateinit var addTaskBinding:FragmentAddTaskBinding

    //private val args: MainActivityArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val listOfTasks = mutableListOf<Task>()
        val adapter = Adapter(listOfTasks)
        itemLayoutBinding = ItemLayoutBinding.inflate(layoutInflater)
        itemLayoutBinding.recyclerView.adapter = adapter
        itemLayoutBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        
        //sets main activity as host fragment
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        listViewBinding = FragmentListViewBinding.inflate(layoutInflater)
        // Display current user date in textView
        val dateDisplay: TextView = listViewBinding.date
        dateDisplay.text = SimpleDateFormat("EEEE, MMMM dd, yyyy").format(Date())

        addTaskBinding= FragmentAddTaskBinding.inflate(layoutInflater)
        addTaskBinding.addButton.setOnClickListener {
            val stringForTask = findViewById<EditText>(R.id.task).text.toString()
            listOfTasks.add(Task(stringForTask)).toString()
            addTaskBinding.task.text.clear()

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
        itemTouchHelper.attachToRecyclerView(itemLayoutBinding.recyclerView)

       //args.userEditTask

        fun updated(task: Task) {
            addTaskBinding.task.setText(task.title)
        }

    }


}


