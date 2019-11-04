package br.com.todolist.toDoList.database

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.todolist.toDoList.model.ToDo

@Database(version = 1, entities = arrayOf(ToDo::class))
abstract class ToDoDatabase: RoomDatabase(){
    abstract fun toDo(): ToDoDao
}