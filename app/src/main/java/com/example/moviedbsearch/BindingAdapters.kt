package com.example.moviedbsearch

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.moviedbsearch.model.*
import com.example.moviedbsearch.ui.adapters.*
import com.example.moviedbsearch.util.Constants.POSTER_URL

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(imageView: ImageView, url:String? ) {
        if (url != null) {
            if(url.isNotEmpty()) {
                Glide.with(imageView.context)
                    .load(POSTER_URL + url)
                    .into(imageView)
            }
        }
    }

    @JvmStatic
    @BindingAdapter("android:visibility")
    fun bindVisibility(view: View, visible: Boolean) {
        view.visibility = if (visible) View.VISIBLE else View.GONE
    }

    @JvmStatic
    @BindingAdapter("list")
    fun bindList(recyclerView: RecyclerView, list: List<Movies>?) {
        if(recyclerView.adapter is PopularAdapter) {
            if (list != null) {
                (recyclerView.adapter as PopularAdapter).updateItems(list)
            }
        }
    }

    @JvmStatic
    @BindingAdapter("searchlist")
    fun bindSearchList(recyclerView: RecyclerView, list: List<SearchResult>?) {
        if(recyclerView.adapter is SearchAdapter) {
            if (list != null) {
                (recyclerView.adapter as SearchAdapter).updateItems(list)
            }
        }
    }

    @JvmStatic
    @BindingAdapter("castlist")
    fun bindCastList(recyclerView: RecyclerView, list: List<Cast>?) {
        if(recyclerView.adapter is CastAdapter) {
            if (list != null) {
                (recyclerView.adapter as CastAdapter).updateItems(list)
            }
        }
    }

    @JvmStatic
    @BindingAdapter("videolist")
    fun bindVideoList(recyclerView: RecyclerView, list: List<Video>?) {
        if(recyclerView.adapter is VideoAdapter) {
            if (list != null) {
                (recyclerView.adapter as VideoAdapter).updateItems(list)
            }
        }
    }

    @JvmStatic
    @BindingAdapter("movieslist")
    fun bindCastMoviesList(recyclerView: RecyclerView, list: List<CastMovie>?) {
        if(recyclerView.adapter is CastMovieAdapter) {
            if (list != null) {
                (recyclerView.adapter as CastMovieAdapter).updateItems(list)
            }
        }
    }

    @JvmStatic
    @BindingAdapter("tvlist")
    fun bindTvList(recyclerView: RecyclerView, list: List<CastTv>?) {
        if(recyclerView.adapter is CastTvAdapter) {
            if (list != null) {
                (recyclerView.adapter as CastTvAdapter).updateItems(list)
            }
        }
    }

}