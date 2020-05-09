package com.lastreacts.filteredfeeded.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.lastreacts.filteredfeeded.R
import com.lastreacts.filteredfeeded.extensions.EMPTY
import com.lastreacts.filteredfeeded.ui.adapters.TweetsAdapter
import com.lastreacts.filteredfeeded.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_tweets_list.*

class TweetsListFragment : BaseFragment() {

    companion object {
        const val WORDS_KEY = "TweetsListFragment::WORDS_KEY"
    }

    override fun layoutRes(): Int = R.layout.fragment_tweets_list

    private lateinit var words: String

    private val adapter = TweetsAdapter { id ->
        // TODO: implement TweetDetailFragment retrived from Room
        Toast.makeText(context, "$id To TweerDetailFragmetn!", Toast.LENGTH_SHORT).show()
    }

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
        arguments?.let {
            if (it.containsKey(WORDS_KEY)) {
                words = it.getString(WORDS_KEY, String.EMPTY)
            }
        }
        initialiseRecyclerView()

        adapter.tweetsList = listOf("David", "Cruz", "Anaya")
    }

    private fun initialiseRecyclerView() = tweetsListRecyclerView?.let {
        it.layoutManager = LinearLayoutManager(context)
        it.setHasFixedSize(true)
        it.adapter = adapter
    }

}