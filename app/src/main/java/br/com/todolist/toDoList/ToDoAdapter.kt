package br.com.todolist.toDoList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import br.com.todolist.R
import kotlinx.android.synthetic.main.item_todo.view.*

class ToDoAdapter(val toDoList: List<ToDo>) :
    RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>() {

    var clickListener: ClickItemListener? = null

    fun setClickItemListener(clickItemListener: ClickItemListener){
        clickListener = clickItemListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        return ToDoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        )
    }

    override fun getItemCount(): Int = toDoList.size

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val toDoItem = toDoList[position]

        holder.name.text = toDoItem.name
        holder.description.text = toDoItem.description
        holder.check.isChecked = toDoItem.check
    }


    inner class ToDoViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        override fun onClick(p0: View?) {
            clickListener?.onClick(adapterPosition)
        }

        init {
            itemView.setOnClickListener(this)
        }

        val name = itemView.nameTxt
        val description = itemView.descriptionTxt
        val check = itemView.checkBox


    }
}