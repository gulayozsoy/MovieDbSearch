package com.example.moviedbsearch.ui.mainscreen

import android.content.Intent
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import com.example.moviedbsearch.base.BaseFragment
import com.example.moviedbsearch.databinding.FragmentMoviesSearchBinding
import com.example.moviedbsearch.model.SearchResult
import com.example.moviedbsearch.ui.SearchItemsClickListener
import com.example.moviedbsearch.ui.adapters.SearchAdapter
import com.example.moviedbsearch.ui.detail.DetailMovieActivity
import com.example.moviedbsearch.util.Constants.MOVIESITEM
import com.example.moviedbsearch.util.Constants.SEARCHITEM
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class MoviesSearchFragment : BaseFragment<FragmentMoviesSearchBinding>(), SearchItemsClickListener {

    private lateinit var searchAdapter: SearchAdapter

    private val mSharedViewModel : SearchViewModel by sharedViewModel()

    override fun getViewBinding(container: ViewGroup?): FragmentMoviesSearchBinding =
        FragmentMoviesSearchBinding.inflate(layoutInflater, container, false).also {
            it.setVariable(BR.viewmodel, mSharedViewModel)
            it.lifecycleOwner = this@MoviesSearchFragment
        }

    override fun setUpViews() {
        searchAdapter = SearchAdapter(this)
        binding.searchRecyclerView.adapter = searchAdapter
    }

    override fun onSearchItemClick(searchItem: SearchResult) {
        val intent = Intent(activity, DetailMovieActivity::class.java)
        intent.putExtra(MOVIESITEM, searchItem.id)
        startActivity(intent)
    }

}