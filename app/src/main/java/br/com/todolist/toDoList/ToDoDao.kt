package br.com.todolist.toDoList

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ToDoDao{

    @Query("SELECT * FROM toDo")
    fun getAll():List<ToDo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToDo(toDo:ToDo)

}