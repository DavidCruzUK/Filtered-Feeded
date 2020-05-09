package com.lastreacts.filteredfeeded.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lastreacts.filteredfeeded.R
import com.lastreacts.filteredfeeded.ui.base.BaseFragment

class TweetsListFragment: BaseFragment() {

    override fun layoutRes(): Int = R.layout.fragment_tweets_list

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getAppComponent().inject(this)
        return inflater.inflate(layoutRes(), container, false)
    }

}