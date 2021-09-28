package com.example.planyourday

import android.content.pm.LauncherApps
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.fragment.findNavController
import com.example.planyourday.databinding.FragmentAddTaskBinding
import com.example.planyourday.fragments.ListViewFragment
import com.example.planyourday.model.Task
import java.lang.ClassCastException

class AddTaskFragment : Fragment() {
    private var _binding : FragmentAddTaskBinding? = null
    private val binding get() = _binding!!
    private val listOfTasks = mutableListOf<Task>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentAddTaskBinding.inflate(inflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addButton.setOnClickListener {
            val stringForTask = binding.task.text.toString()
            listOfTasks.add(Task(stringForTask)).toString()
            binding.task.text.clear(  )
/*            val parentFragment: Fragment = ListViewFragment()
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.add(R.id.action_addTaskFragment_to_listViewFragment, parentFragment).addToBackStack(null).commit()

            val action = AddTaskFragmentDirections.actionAddTaskFragmentToEditFragment( stringForTask)
            findNavController().navigate(action)*/
        }

    }

}