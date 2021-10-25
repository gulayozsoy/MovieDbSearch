package com.example.moviedbsearch.ui.mainscreen

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.SearchView
import com.example.moviedbsearch.R
import com.example.moviedbsearch.base.BaseActivity
import com.example.moviedbsearch.databinding.ActivityMainScreenBinding
import com.example.moviedbsearch.model.Movies
import com.example.moviedbsearch.ui.ItemsClickListener
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.databinding.library.baseAdapters.BR
import com.example.moviedbsearch.ui.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator


class MainScreenActivity : BaseActivity<ActivityMainScreenBinding>() {

    private val searchViewModel by viewModel<SearchViewModel>()

    val popularFragment = MostPopularMoviesFragment()

    override fun getViewBinding(): ActivityMainScreenBinding =
        ActivityMainScreenBinding.inflate(layoutInflater).also {
            it.setVariable(BR.viewModel, searchViewModel)
            it.lifecycleOwner = this@MainScreenActivity
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addPopularFragment()
        setSupportActionBar(binding.mainToolBar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        binding.tabViewPagerLayout.visibility = View.GONE

        setupViewPager()

    }

    private fun setupViewPager() {

        val pagerAdapter = ViewPagerAdapter(this, 3)
        val fragmentList = listOf(MoviesSearchFragment(), PeopleSearchFragment(), TvSearchFragment())
        pagerAdapter.fragmentsList.addAll(fragmentList)
        binding.viewpager.apply {
            adapter = pagerAdapter
            currentItem = 0
        }

        TabLayoutMediator(binding.tabLayout, binding.viewpager) {
                tab, position ->
            when(position) {
                0 -> tab.text ="Movies"
                1 -> tab.text ="People"
                else -> tab.text = "TV"
            }
        }.attach()
    }

    private fun addPopularFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.popular_container, popularFragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        val menuItem = menu.findItem(R.id.action_search)
        val searchView = menuItem.actionView as SearchView
        searchView.let {
            it.queryHint = getString(R.string.search)
            it.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    Log.d("onQueryTextSubmit", query)
                    binding.hintText.visibility = View.GONE
                    searchViewModel.getQuery(query)
                    searchView.clearFocus()
                    return true
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    binding.canceltext.visibility = View.VISIBLE
                    //viewModel.getQuery(newText)  --> server'ın request sayısı sınırlı olabilir.
                    return true
                }
            })
        }


        menuItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(menuItem: MenuItem): Boolean {
                binding.popularContainer.visibility = View.GONE
                binding.tabViewPagerLayout.visibility = View.VISIBLE
                return true
            }

            override fun onMenuItemActionCollapse(menuItem: MenuItem): Boolean {
                binding.popularContainer.visibility = View.VISIBLE
                binding.tabViewPagerLayout.visibility = View.GONE
                return true
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_search -> {
                binding.canceltext.visibility = View.GONE
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

}