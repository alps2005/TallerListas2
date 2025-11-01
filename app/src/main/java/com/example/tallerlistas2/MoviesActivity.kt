package com.example.tallerlistas2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MoviesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_movies)

        var selectedGenre = intent.getStringExtra("genre")

        var movies = listOf(
            Movies("Matrix", "Accion", "https://m.media-amazon.com/images/M/MV5BNGE1YzI4NzMtZTUxNi00Y2I5LTg2MmQtODE0NThmYTFmMDk0XkEyXkFqcGc@._V1_.jpg"),
            Movies("One Battle After Another", "Accion", "https://m.media-amazon.com/images/M/MV5BMzBkZmQ0NjMtNTZlMy00ZjdlLTg5ODUtYWFlNGM0YzE3MTg0XkEyXkFqcGc@._V1_.jpg"),
            Movies("Saving Private Ryan", "Accion", "https://m.media-amazon.com/images/M/MV5BZGZhZGQ1ZWUtZTZjYS00MDJhLWFkYjctN2ZlYjE5NWYwZDM2XkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg"),
            Movies("Birdman or (the unexpected virtue of ignorance)", "Drama", "https://m.media-amazon.com/images/M/MV5BODAzNDMxMzAxOV5BMl5BanBnXkFtZTgwMDMxMjA4MjE@._V1_.jpg"),
            Movies("Dead poet's society", "Drama", "https://m.media-amazon.com/images/I/617-2I06oGL._AC_UF1000,1000_QL80_.jpg"),
            Movies("Good Will Hunting", "Drama", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQiUN8DuvdvPOa-UeJ8Ihdo975QTREAz6mnyw&s"),
            Movies("Scary movie", "Comedia", "https://resizing.flixster.com/-XZAfHZM39UwaGJIFWKAE8fS0ak=/v3/t/assets/p25765_p_v12_aj.jpg"),
            Movies("This is the end", "Comedia", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXoNXw0jz4NghhEV8AIr9nvtKf0bUbS8O-tQ&s"),
            Movies("Superbad", "Comedia", "https://m.media-amazon.com/images/I/91InXnC4EAL._AC_UF1000,1000_QL80_.jpg"),
        )

        var filteredMovies = movies.filter { it.genre.equals(selectedGenre, ignoreCase = true) }

        var rvMovies: RecyclerView = findViewById(R.id.rvMovies)
        rvMovies.layoutManager = GridLayoutManager(this, 2)
        rvMovies.adapter = MoviesAdapter(filteredMovies, this)
    }
}
