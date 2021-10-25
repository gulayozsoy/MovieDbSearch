package com.example.moviedbsearch.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedbsearch.databinding.LayoutMovieItemBinding
import com.example.moviedbsearch.model.CastMovie


class CastMovieAdapter():
    RecyclerView.Adapter<CastMovieAdapter.MovieViewHolder>(){

    private var list: MutableList<CastMovie> = mutableListOf()

    fun updateItems(items: List<CastMovie>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MovieViewHolder(LayoutMovieItemBinding.inflate(layoutInflater, parent, false))
    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int = list.size

    inner class MovieViewHolder(private val binding: LayoutMovieItemBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(position: Int) {
            val item = list[position]
            binding.castMovie = item
            binding.executePendingBindings()

        }
    }
}
