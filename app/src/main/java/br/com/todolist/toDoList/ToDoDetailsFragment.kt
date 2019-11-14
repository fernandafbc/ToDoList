package br.com.todolist.toDoList


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs

import br.com.todolist.R
import br.com.todolist.ToDoListApplication
import br.com.todolist.toDoList.model.ToDo
import kotlinx.android.synthetic.main.fragment_to_do_details.*

/**
 * A simple [Fragment] subclass.
 */
class ToDoDetailsFragment : Fragment() {

    private var toDo: ToDo? = null
    private lateinit var itemId: String
    var isEditing = false

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
        itemId = arguments?.getString("itemId") ?: ""

        retrieveItemDb()

        deleteBtn.setOnClickListener {

        }

        editBtn.setOnClickListener {

            if(isEditing)
            {
                toDo?.let { toDoItem ->
                    val newToDo = ToDo(
                        toDoItem.id,
                        nameEdT.text.toString(),
                        descriptionEdT.text.toString(),
                        toDoItem.check
                    )

                    ToDoListApplication.database?.toDo()?.insertToDo(newToDo)
                }
                it.findNavController().popBackStack()

            }
            else{
                nameEdT.isEnabled = true
                descriptionEdT.isEnabled = true
                editBtn.text = "concluir"
                isEditing = true
            }
        }
    }

    private fun retrieveItemDb() {
        // pegar o a tarefa

        toDo = ToDoListApplication.database?.toDo()?.loadSingle(itemId)

        // mostrar na tela os dados dela
        showToDoInformation(toDo)
    }

    private fun showToDoInformation(toDoItem: ToDo?) {
        // mostrar
        toDoItem?.let {
            nameEdT.setText(it.name)
            descriptionEdT.setText(it.description)
        }
    }

}
