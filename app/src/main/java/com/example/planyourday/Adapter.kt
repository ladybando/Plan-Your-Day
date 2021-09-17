package com.example.planyourday

import android.graphics.Paint
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.planyourday.databinding.TasksviewBinding



class Adapter(private val listOfTasks: MutableList<Task>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    private lateinit var binding: TasksviewBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = TasksviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val items = inflater.inflate(R.layout.tasksview, parent, false)
        // Return a new holder instance
        return ViewHolder(items)

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listOfTasks.get(position)
        val checkbox = holder.checkbox
        holder.title.setText(item.title)

        // Strike through text on checkbox click
        /*checkbox.setOnClickListener{
            holder.title.setPaintFlags(holder.title.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
        }
        */
        // Add and remove strikethrough when checked
        checkbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                holder.title.setPaintFlags(holder.title.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
            } else {
                holder.title.paintFlags = Paint.ANTI_ALIAS_FLAG
            }

        }

        // On click of task go to edit screen
        /*holder.itemView.setOnClickListener {

        }*/


    }

    override fun getItemCount(): Int {
        return listOfTasks.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkbox: CheckBox = itemView.findViewById<CheckBox>(R.id.checkbox)

        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val title: TextView = itemView.findViewById<TextView>(R.id.enteredTask)
    }
}


