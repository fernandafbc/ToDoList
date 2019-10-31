package br.com.todolist.toDoList


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import br.com.todolist.R
import br.com.todolist.ToDoListApplication
import kotlinx.android.synthetic.main.fragment_to_do_list.*

/**
 * A simple [Fragment] subclass.
 */
class ToDoListFragment : Fragment() {

    val toDoList: ArrayList<ToDo> = ArrayList()
    private val toDoAdapter: ToDoAdapter

    init {
        toDoAdapter = ToDoAdapter(toDoList)
        toDoAdapter.setClickItemListener(object : ClickItemListener {
            override fun onClick(position: Int) {
                val item = toDoList[position]

//                val action = ToDoListFragmentDirections.
//                findNavController().navigate(R.id.action_toDoListFragment_to_toDoDetails2)
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_to_do_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toDoRecyclerView.layoutManager = LinearLayoutManager(activity)
        toDoRecyclerView.adapter = toDoAdapter

        addBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_toDoListFragment_to_addToDoFragment)
        }

//        ToDoListApplication.database?.toDo()?.getAll().let {
//            it?.forEach { toDoModel ->
//                Log.i("Fernanda", toDoModel.name)
//            }
//        }

    }

    override fun onResume() {
        super.onResume()

        updateList()
    }

    private fun updateList() {
        ToDoListApplication.database?.toDo()?.getAll()?.let {
            toDoList.clear()
            toDoList.addAll(it)
        }.also {
            toDoAdapter.notifyDataSetChanged()
        }

    }


}
