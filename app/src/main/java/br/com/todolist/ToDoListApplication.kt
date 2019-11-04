package br.com.todolist

import android.app.Application
import androidx.room.Room
import br.com.todolist.toDoList.database.ToDoDatabase

class ToDoListApplication: Application(){

    companion object{
        var database : ToDoDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(this, ToDoDatabase::class.java, "my-db").allowMainThreadQueries().build()

    }
}