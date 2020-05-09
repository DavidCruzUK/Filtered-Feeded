package com.lastreacts.filteredfeeded.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
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
            searchButton.id -> goToTweetsListFragmentOrError()
        }
    }

    private fun goToTweetsListFragmentOrError() {
        wordsEditTextHasContent()?.let {
            navController.navigate(
                R.id.action_mainFragment_to_tweetsListFragment,
                bundleOf(TweetsListFragment.WORDS_KEY to it)
            )
        } ?: kotlin.run {
            Toast.makeText(
                context,
                getText(R.string.empty_search_toast_text),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun addOnClickListeners() {
        searchButton.setOnClickListener(this)
    }

    private fun wordsEditTextHasContent(): String? {
        return if (!wordsToSearchEditText.text.isNullOrBlank()) {
            wordsToSearchEditText.text.toString().trim()
        } else {
            null
        }
    }

}