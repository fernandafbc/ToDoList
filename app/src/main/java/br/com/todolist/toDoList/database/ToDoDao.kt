package br.com.todolist.toDoList.database

import androidx.room.*
import br.com.todolist.toDoList.model.ToDo

@Dao
interface ToDoDao {

    @Query("SELECT * FROM toDo")
    fun getAll(): List<ToDo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertToDo(toDo: ToDo)

    @Query("DELETE FROM todo WHERE id = :id")
    fun delete(id: String)

    @Query("SELECT * FROM toDo WHERE id=:id ")
    fun loadSingle(id: String): ToDo

    // criar o pegar um unico item
    // procurar na internet como
    // ex: android room get single item
}