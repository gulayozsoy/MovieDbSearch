package com.example.moviedbsearch.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedbsearch.databinding.PopularMovieItemBinding
import com.example.moviedbsearch.model.Movies
import com.example.moviedbsearch.ui.ItemsClickListener

class PopularAdapter(val clickListener: ItemsClickListener):
    RecyclerView.Adapter<PopularAdapter.MoviesViewHolder>(){

    private var list: MutableList<Movies> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MoviesViewHolder(PopularMovieItemBinding.inflate(layoutInflater, parent, false))
    }


    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int = list.size

    fun updateItems(moviesList: List<Movies>?) {
        list.clear()
        if (moviesList != null) {
            list.addAll(moviesList)
        }
        notifyDataSetChanged()
    }

    inner class MoviesViewHolder(private val binding: PopularMovieItemBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(position: Int) {
            val item = list[position]
            binding.movies = item
            binding.itemsClickInterface = clickListener
            binding.executePendingBindings()
        }
    }
}
