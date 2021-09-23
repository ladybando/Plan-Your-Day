package com.example.planyourday

import android.os.Bundle
import android.text.Layout
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.planyourday.EditFragmentDirections as EditFragmentDirections


class EditFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val save: Button = view.findViewById<Button>(R.id.saveBtn)
        val userEditTask = view.findViewById<EditText>(R.id.editTask).text.toString()
        val action = EditFragmentDirections.actionEditFragmentToMainActivity(userEditTask)
        save.setOnClickListener {
            findNavController().navigate(action)
        }
    }
}




