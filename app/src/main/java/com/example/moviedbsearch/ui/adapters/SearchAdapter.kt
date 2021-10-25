package com.example.moviedbsearch.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedbsearch.databinding.SearchItemBinding
import com.example.moviedbsearch.model.SearchResult
import com.example.moviedbsearch.ui.SearchItemsClickListener

class SearchAdapter(val clickListener: SearchItemsClickListener):
    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>(){

    private var list: MutableList<SearchResult> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SearchViewHolder(SearchItemBinding.inflate(layoutInflater, parent, false))
    }


    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int = list.size

    fun updateItems(resultList: List<SearchResult>?) {
        if (resultList != null) {
            list.clear()
            list.addAll(resultList)
        }
        notifyDataSetChanged()
    }

    inner class SearchViewHolder(private val binding: SearchItemBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(position: Int) {
            val item = list[position]
            binding.searchresult = item
            binding.searchItemsClickInterface = clickListener
            binding.executePendingBindings()
        }
    }
}