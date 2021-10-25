package com.example.moviedbsearch.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moviedbsearch.databinding.LayoutVideoItemBinding
import com.example.moviedbsearch.model.Video
import com.example.moviedbsearch.ui.VideoClickListener

class VideoAdapter(val clickListener: VideoClickListener):
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder>(){

    private var list: MutableList<Video> = mutableListOf()

    fun updateItems(items: List<Video>) {
        list.clear()
        list.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return VideoViewHolder(LayoutVideoItemBinding.inflate(layoutInflater, parent, false))
    }


    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int = list.size

    inner class VideoViewHolder(private val binding: LayoutVideoItemBinding):
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(position: Int) {
            val item = list[position]
            binding.video = item
            binding.itemClickInterface = clickListener

        }
    }
}