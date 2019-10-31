package br.com.todolist.toDoList

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(version = 1, entities = arrayOf(ToDo::class))
abstract class ToDoDatabase: RoomDatabase(){
    abstract fun toDo(): ToDoDao
}