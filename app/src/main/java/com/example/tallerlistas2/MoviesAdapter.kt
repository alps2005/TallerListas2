package com.example.tallerlistas2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MoviesAdapter(var movies: List<Movies>, var activity: MoviesActivity):
    RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MoviesViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_movies , parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: MoviesViewHolder,
        position: Int
    ) {
        var movie: Movies = movies[position]
        holder.tvName.text = movie.name
        holder.tvGenre.text = movie.genre
        Glide.with(activity).load(movie.img).
        into(holder.imgAvatar)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    class MoviesViewHolder(view: View): RecyclerView.ViewHolder(view){
        var imgAvatar: ImageView = view.findViewById(R.id.imgAvatar)
        var tvName: TextView = view.findViewById(R.id.tvName)
        var tvGenre: TextView = view.findViewById(R.id.tvGenre)
    }
}