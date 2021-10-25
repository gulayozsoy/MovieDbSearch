package com.example.moviedbsearch.ui.adapters

import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.fragment.app.Fragment
import com.example.moviedbsearch.model.SearchResult


class ViewPagerAdapter(fragmentActivity: FragmentActivity, val itemsCount: Int) : FragmentStateAdapter(fragmentActivity) {

    var fragmentsList = mutableListOf<Fragment>()

    override fun getItemCount(): Int  = itemsCount


    override fun createFragment(position: Int): Fragment = fragmentsList[position]

}

