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
import com.lastreacts.filteredfeeded.extensions.getViewModel
import com.lastreacts.filteredfeeded.extensions.showToast
import com.lastreacts.filteredfeeded.ui.base.BaseFragment
import com.lastreacts.filteredfeeded.ui.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

class MainFragment : BaseFragment(), View.OnClickListener {

    @Inject
    lateinit var mainViewModel: MainViewModel

    private val viewModel: MainViewModel by lazy {
        getViewModel { mainViewModel }
    }

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
        stopTweetStreamIfExisting()
    }

    override fun layoutRes(): Int = R.layout.fragment_main

    override fun showProgressBar(show: Boolean) {
        progressBar.visibility = if (show) View.VISIBLE else View.GONE
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            searchButton.id -> goToTweetsListFragmentOrError()
        }
    }

    private fun stopTweetStreamIfExisting() {
        viewModel.stopStream()
    }

    private fun addOnClickListeners() {
        searchButton.setOnClickListener(this)
    }

    private fun goToTweetsListFragmentOrError() {
        showProgressBar(true)
        wordsEditTextHasContent()?.let {
            navController.navigate(
                R.id.action_mainFragment_to_tweetsListFragment,
                bundleOf(TweetsListFragment.WORDS_KEY to it)
            )
            showProgressBar(false)
        } ?: kotlin.run {
            context?.showToast(getText(R.string.empty_search_toast_text).toString())
            showProgressBar(false)
        }
    }

    private fun wordsEditTextHasContent(): String? {
        return if (!wordsToSearchEditText.text.isNullOrBlank()) {
            wordsToSearchEditText.text.toString().trim()
        } else {
            null
        }
    }

}