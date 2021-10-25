package com.example.moviedbsearch.ui.mainscreen

import android.content.Intent
import android.view.ViewGroup
import androidx.databinding.library.baseAdapters.BR
import com.example.moviedbsearch.base.BaseFragment
import com.example.moviedbsearch.databinding.FragmentPopularMoviesBinding
import com.example.moviedbsearch.model.Movies
import com.example.moviedbsearch.ui.ItemsClickListener
import com.example.moviedbsearch.ui.adapters.PopularAdapter
import com.example.moviedbsearch.ui.detail.DetailMovieActivity
import com.example.moviedbsearch.util.Constants.MOVIESITEM
import org.koin.androidx.viewmodel.ext.android.viewModel


class MostPopularMoviesFragment : BaseFragment<FragmentPopularMoviesBinding>(), ItemsClickListener {

    private lateinit var popularAdapter: PopularAdapter

    private val sharedViewModel by viewModel<MainScreenViewModel>()

    override fun getViewBinding(container: ViewGroup?): FragmentPopularMoviesBinding =
        FragmentPopularMoviesBinding.inflate(layoutInflater, container, false).also {
            it.setVariable(BR.viewmodel, sharedViewModel)
            it.lifecycleOwner = this
        }

    override fun setUpViews() {
        popularAdapter= PopularAdapter(this)
        binding.popularRecyclerView.adapter = popularAdapter
    }

    override fun pullAndObserveData() {
        sharedViewModel.getPopularMovies()
    }

    override fun onItemClick(movieItem: Movies) {
        val intent = Intent(activity, DetailMovieActivity::class.java)
        intent.putExtra(MOVIESITEM, movieItem.id)
        startActivity(intent)
    }


}