package com.example.planyourday.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.planyourday.fragments.EditFragment
import com.example.planyourday.R
import com.example.planyourday.model.Task
import com.example.planyourday.databinding.ItemLayoutBinding


class Adapter(private val listOfTasks: MutableList<Task>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    private lateinit var binding: ItemLayoutBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //inflates
        binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val items = inflater.inflate(R.layout.item_layout, parent, false)
        // Return a new holder instance
        return ViewHolder(items)

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listOfTasks[position]
        val checkbox = holder.checkbox
        holder.title.setText(item.title)

        // Add and remove strikethrough when checked
        checkbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                holder.title.setPaintFlags(holder.title.getPaintFlags() or Paint.STRIKE_THRU_TEXT_FLAG)
            } else {
                holder.title.paintFlags = Paint.ANTI_ALIAS_FLAG
            }
        }



        // On long click of task go to edit screen
        holder.itemView.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                val activity = v!!.context as AppCompatActivity
                val editFragment = EditFragment()
                activity.supportFragmentManager.beginTransaction().replace(R.id.listViewFragment, editFragment).addToBackStack(null).commit()
            }
        })


    }

    override fun getItemCount(): Int {
        return listOfTasks.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val checkbox: CheckBox = itemView.findViewById(R.id.checkbox)

        // Your holder should contain and initialize a member variable
        // for any view that will be set as you render a row
        val title: TextView = itemView.findViewById(R.id.enteredTask)
    }
}





