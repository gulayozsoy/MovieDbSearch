package com.example.moviedbsearch.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedbsearch.databinding.LayoutCastItemBinding
import com.example.moviedbsearch.model.Cast
import com.example.moviedbsearch.ui.CastClickListener


class CastAdapter(val clickListener: CastClickListener):
    RecyclerView.Adapter<CastAdapter.CastViewHolder>(){

    private var list: MutableList<Cast> = mutableListOf()

    fun updateItems(items: List<Cast>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return CastViewHolder(LayoutCastItemBinding.inflate(layoutInflater, parent, false))
    }


    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int = list.size

    inner class CastViewHolder(private val binding: LayoutCastItemBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(position: Int) {
            val item = list[position]
            binding.cast = item
            binding.itemClickInterface = clickListener


        }
    }
}
