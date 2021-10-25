package com.example.moviedbsearch.ui.detail


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.databinding.library.baseAdapters.BR
import com.example.moviedbsearch.base.BaseActivity
import com.example.moviedbsearch.databinding.ActivityDetailMovieBinding
import com.example.moviedbsearch.model.Cast
import com.example.moviedbsearch.model.Video
import com.example.moviedbsearch.ui.CastClickListener
import com.example.moviedbsearch.ui.VideoClickListener
import com.example.moviedbsearch.ui.adapters.CastAdapter
import com.example.moviedbsearch.ui.adapters.VideoAdapter
import com.example.moviedbsearch.ui.cast.CastActivity
import com.example.moviedbsearch.util.Constants.CASTITEM
import com.example.moviedbsearch.util.Constants.MOVIESITEM
import com.example.moviedbsearch.util.Constants.YOUTUBE_WATCH_URL
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailMovieActivity : BaseActivity<ActivityDetailMovieBinding>(), VideoClickListener, CastClickListener {

    private val detailViewModel by viewModel<DetailViewModel>()

    private lateinit var videoAdapter: VideoAdapter
    private lateinit var castAdapter: CastAdapter

    private var movieId:Int ? = null


    override fun getViewBinding(): ActivityDetailMovieBinding
            =  ActivityDetailMovieBinding.inflate(layoutInflater).also {
                it.setVariable(BR.viewmodel, detailViewModel)
                it.lifecycleOwner = this@DetailMovieActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.detailToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        setUpRecyclerViews()

        intent.extras.let {
            movieId= it?.getInt(MOVIESITEM)!!
        }

        movieId?.let { detailViewModel.getData(it) }

    }

    private fun setUpRecyclerViews() {
        videoAdapter = VideoAdapter(this)
        castAdapter = CastAdapter(this)

        binding.recyclerViewVideos.adapter = videoAdapter
        binding.recyclerViewCast.adapter = castAdapter
    }

    override fun onVideoItemClick(video: Video) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(YOUTUBE_WATCH_URL + video.key)
        startActivity(intent)
    }

    override fun onCastItemClick(castItem: Cast) {
        val intent = Intent(this, CastActivity::class.java)
        intent.putExtra(CASTITEM, castItem)
        startActivity(intent)
    }
}