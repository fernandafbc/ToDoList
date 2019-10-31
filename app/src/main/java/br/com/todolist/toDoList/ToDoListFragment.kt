package br.com.todolist.toDoList


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import br.com.todolist.R
import kotlinx.android.synthetic.main.fragment_to_do_list.*

/**
 * A simple [Fragment] subclass.
 */
class ToDoListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_to_do_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_toDoListFragment_to_addToDoFragment)
        }
    }


}