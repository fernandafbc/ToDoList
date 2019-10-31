package br.com.todolist.toDoList


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import br.com.todolist.R
import br.com.todolist.ToDoListApplication
import kotlinx.android.synthetic.main.fragment_add_to_do.*
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class AddToDoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_to_do, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addButton.setOnClickListener {
            val id = UUID.randomUUID().toString()
            val name = nameEdTxt.text.toString()
            val description = descriptionEdTxt.text.toString()
            val toDo = ToDo(id, name, description, false)

            ToDoListApplication.database?.toDo()?.insertToDo(toDo)

            it.findNavController().popBackStack()
        }
    }


}
