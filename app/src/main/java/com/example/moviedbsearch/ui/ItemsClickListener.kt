package com.example.moviedbsearch.ui

import com.example.moviedbsearch.model.*

interface ItemsClickListener {
    fun onItemClick(movieItem: Movies)
}

interface SearchItemsClickListener {
    fun onSearchItemClick(searchItem: SearchResult)
}

interface CastClickListener {
    fun onCastItemClick(castItem: Cast)
}

interface VideoClickListener {
    fun onVideoItemClick(video: Video)
}