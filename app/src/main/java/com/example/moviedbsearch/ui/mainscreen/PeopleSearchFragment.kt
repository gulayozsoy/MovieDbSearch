package com.example.moviedbsearch.ui.mainscreen

import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.databinding.library.baseAdapters.BR
import androidx.fragment.app.activityViewModels
import com.example.moviedbsearch.base.BaseFragment
import com.example.moviedbsearch.databinding.FragmentPeopleSearchBinding
import com.example.moviedbsearch.model.SearchResult
import com.example.moviedbsearch.ui.SearchItemsClickListener
import com.example.moviedbsearch.ui.adapters.SearchAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class PeopleSearchFragment : BaseFragment<FragmentPeopleSearchBinding>(), SearchItemsClickListener {

    private lateinit var searchAdapter: SearchAdapter

    private val pSharedViewModel : SearchViewModel by sharedViewModel()

    override fun getViewBinding(container: ViewGroup?): FragmentPeopleSearchBinding =
        FragmentPeopleSearchBinding.inflate(layoutInflater, container, false).also {
            it.setVariable(BR.viewmodel, pSharedViewModel)
            it.lifecycleOwner = this@PeopleSearchFragment
        }

    override fun setUpViews() {
        searchAdapter = SearchAdapter(this)
        binding.searchRecyclerView.adapter = searchAdapter
    }

    override fun onSearchItemClick(searchItem: SearchResult) {
        Toast.makeText(activity, "Item Clicked On", LENGTH_SHORT).show()
    }

}