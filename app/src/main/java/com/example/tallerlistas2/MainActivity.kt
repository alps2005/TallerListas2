package com.example.tallerlistas2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val GenreList: ListView = findViewById(R.id.GenreList)
        val elements = listOf("Accion", "Drama", "Comedia")
        val adapter = ArrayAdapter(this, R.layout.item_genre, elements)
        GenreList.adapter = adapter

        GenreList.setOnItemClickListener()
        { p: AdapterView<*>, view: View, position: Int, id: Long ->
            val genre = elements[position]
            var intento = Intent(this, MoviesActivity::class.java)
            intento.putExtra("genre", genre)
            startActivity(intento)
        }


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}