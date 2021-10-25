package com.example.moviedbsearch.ui.mainscreen


import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.library.baseAdapters.BR
import com.example.moviedbsearch.base.BaseFragment
import com.example.moviedbsearch.databinding.FragmentTvSearchBinding
import com.example.moviedbsearch.model.SearchResult
import com.example.moviedbsearch.ui.SearchItemsClickListener
import com.example.moviedbsearch.ui.adapters.SearchAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class TvSearchFragment : BaseFragment<FragmentTvSearchBinding>(),
    SearchItemsClickListener {

    private lateinit var searchAdapter: SearchAdapter

    private val tSharedViewModel : SearchViewModel by sharedViewModel()

    override fun getViewBinding(container: ViewGroup?): FragmentTvSearchBinding =
        FragmentTvSearchBinding.inflate(layoutInflater, container, false).also {
            it.setVariable(BR.viewmodel, tSharedViewModel)
            it.lifecycleOwner = this@TvSearchFragment
        }

    override fun setUpViews() {
        searchAdapter = SearchAdapter(this)
        binding.searchRecyclerView.adapter = searchAdapter
    }

    override fun onSearchItemClick(searchItem: SearchResult) {
        Toast.makeText(activity, "Item Clicked On", Toast.LENGTH_SHORT).show()
    }
}