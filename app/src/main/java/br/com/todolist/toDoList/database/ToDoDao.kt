package br.com.todolist.toDoList.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.todolist.toDoList.model.ToDo

@Dao
interface ToDoDao{

    @Query("SELECT * FROM toDo")
    fun getAll():List<ToDo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToDo(toDo: ToDo)

    // criar o pegar um unico item
    // procurar na internet como
    // ex: android room get single item
}