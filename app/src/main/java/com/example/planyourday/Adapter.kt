package com.example.planyourday

import android.graphics.Paint
import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adapter(private val listOfTasks: MutableList<Task>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val items = inflater.inflate(R.layout.tasksview, parent, false)
        // Return a new holder instance
        return ViewHolder(items)

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listOfTasks.get(position)

        holder.title.setText(item.title)

        // Strike through text on checkbox click


        holder.checkbox.onCheckBoxClick

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


