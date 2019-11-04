package br.com.todolist.toDoList


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs

import br.com.todolist.R
import br.com.todolist.toDoList.model.ToDo

/**
 * A simple [Fragment] subclass.
 */
class ToDoDetailsFragment : Fragment() {

    private var itemId: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_to_do_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // o getArguments(arguments no kotlin) pega os argumentos que foram passados
        // e eu coloco na variavel itemId
        // fazendo isso vc precisa pegar esse id e pegar ele na database
        itemId = arguments?.getString("itemId")

        retrieveItemDb()
    }

    private fun retrieveItemDb() {
        // pegar o a tarefa

        // mostrar na tela os dados dela
//        showToDoInformation(toDoItem)
    }

    private fun showToDoInformation(toDoItem: ToDo) {
        // mostrar
    }

}
