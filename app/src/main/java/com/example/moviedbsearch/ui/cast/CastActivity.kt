package com.example.moviedbsearch.ui.cast


import android.os.Bundle
import androidx.databinding.library.baseAdapters.BR
import com.example.moviedbsearch.base.BaseActivity
import com.example.moviedbsearch.databinding.ActivityCastBinding
import com.example.moviedbsearch.model.Cast
import com.example.moviedbsearch.ui.adapters.CastMovieAdapter
import com.example.moviedbsearch.ui.adapters.CastTvAdapter
import com.example.moviedbsearch.util.Constants.CASTITEM
import org.koin.androidx.viewmodel.ext.android.viewModel


class CastActivity : BaseActivity<ActivityCastBinding>() {

    private val castViewModel by viewModel<CastViewModel>()

    private lateinit var castTvAdapter: CastTvAdapter
    private lateinit var castMovieAdapter: CastMovieAdapter

    private lateinit var castItem: Cast

    override fun getViewBinding(): ActivityCastBinding
            =  ActivityCastBinding.inflate(layoutInflater).also {
            it.setVariable(BR.viewmodel, castViewModel)
            it.lifecycleOwner = this@CastActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setUpRecyclerViews()

        intent.extras.let {
            castItem = it?.getParcelable(CASTITEM)!!
        }

        castItem.id?.let { castViewModel.getData(it) }
    }

    private fun setUpRecyclerViews() {
        castTvAdapter = CastTvAdapter()
        castMovieAdapter = CastMovieAdapter()

        binding.recyclerViewTvs.adapter = castTvAdapter
        binding.recyclerViewMovies.adapter = castMovieAdapter
    }


}