package br.com.todolist.mainPage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.todolist.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var a = 10
        var b = 5

        val soma = soma(a, b)

        Toast.makeText(
            this,
            "Valor da soma: $soma",
            Toast.LENGTH_LONG
        ).show()
    }

    fun soma(x: Int, y: Int): Int = x + y
}
