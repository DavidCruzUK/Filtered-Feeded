package com.lastreacts.filteredfeeded.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.lastreacts.filteredfeeded.R
import com.lastreacts.filteredfeeded.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment(), View.OnClickListener {

    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getAppComponent().inject(this)
        return inflater.inflate(layoutRes(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = view.findNavController()
        addOnClickListeners()
    }

    override fun layoutRes(): Int = R.layout.fragment_main

    override fun onClick(v: View?) {
        when (v?.id) {
            searchButton.id -> navController.navigate(R.id.action_mainFragment_to_tweetsListFragment)
        }
    }

    private fun addOnClickListeners() = searchButton.setOnClickListener(this)

}