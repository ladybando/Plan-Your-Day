package com.example.planyourday.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.planyourday.AddTaskFragment
import com.example.planyourday.R
import com.example.planyourday.adapter.Adapter
import com.example.planyourday.databinding.FragmentListViewBinding
import com.example.planyourday.model.Task

class ListViewFragment : Fragment() {
    private var _binding: FragmentListViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListViewBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val listOfTasks = mutableListOf<Task>()
        val adapter = Adapter(listOfTasks)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this.requireContext())
        displayFragment()
    }
    // Embeds the child fragment dynamically
   private fun displayFragment() {
        val childFragment: Fragment = AddTaskFragment()
        val transaction: FragmentTransaction = childFragmentManager.beginTransaction()
        transaction.add(R.id.main_fragment_container, childFragment).addToBackStack(null).commit()
    }

    fun closeFragment(){
        val childFragment = AddTaskFragment()
        val childFragmentView = childFragmentManager.findFragmentById(R.id.action_listViewFragment_to_addTaskFragment)
        if (childFragmentView != null){
            val transaction = childFragmentManager.beginTransaction()
            transaction.remove( childFragment).commit()
        }
    }


}