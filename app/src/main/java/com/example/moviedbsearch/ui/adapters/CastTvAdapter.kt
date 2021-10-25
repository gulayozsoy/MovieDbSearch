package com.example.moviedbsearch.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedbsearch.databinding.LayoutTvItemBinding
import com.example.moviedbsearch.model.CastTv


class CastTvAdapter():
    RecyclerView.Adapter<CastTvAdapter.TvViewHolder>(){

    private var list: MutableList<CastTv> = mutableListOf()

    fun updateItems(items: List<CastTv>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TvViewHolder(LayoutTvItemBinding.inflate(layoutInflater, parent, false))
    }


    override fun onBindViewHolder(holder: TvViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int = list.size

    inner class TvViewHolder(private val binding: LayoutTvItemBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(position: Int) {
            val item = list[position]
            binding.castTv = item
            binding.executePendingBindings()

        }
    }
}
