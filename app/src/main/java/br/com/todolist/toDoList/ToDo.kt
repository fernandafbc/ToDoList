package br.com.todolist.toDoList

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "toDo")
data class ToDo (

    @PrimaryKey
    val id:String,

    val name:String,

    val description:String,

    val check:Boolean
)