package com.example.moviedbsearch.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : ViewBinding>: Fragment() {

    var _binding: T? = null
    val binding get() = _binding ?: throw IllegalStateException("Cannot access view in after view destroyed and before view creation")


    abstract fun getViewBinding(container: ViewGroup?): T

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = getViewBinding(container)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        pullAndObserveData()
    }

    open fun setUpViews() {}

    open fun pullAndObserveData() {}

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}