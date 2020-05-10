package com.lastreacts.filteredfeeded.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.lastreacts.filteredfeeded.R
import com.lastreacts.filteredfeeded.extensions.EMPTY
import com.lastreacts.filteredfeeded.extensions.getViewModel
import com.lastreacts.filteredfeeded.ui.adapters.TweetsAdapter
import com.lastreacts.filteredfeeded.ui.base.BaseFragment
import com.lastreacts.filteredfeeded.ui.interfaces.StreamEventsImpl
import com.lastreacts.filteredfeeded.ui.viewmodels.TweetListViewModel
import kotlinx.android.synthetic.main.fragment_tweets_list.*
import twitter4j.Status
import java.lang.Exception
import javax.inject.Inject

class TweetsListFragment : BaseFragment(), StreamEventsImpl {

    companion object {
        const val WORDS_KEY = "TweetsListFragment::WORDS_KEY"
    }

    @Inject
    lateinit var tweetListViewModel: TweetListViewModel

    private val viewModel: TweetListViewModel by lazy {
        getViewModel { tweetListViewModel }
    }

    override fun layoutRes(): Int = R.layout.fragment_tweets_list

    private lateinit var words: String

    private val adapter = TweetsAdapter { id ->
        // TODO: implement TweetDetailFragment retrieved from Room
        Toast.makeText(context, "$id To TweetDetailFragment!", Toast.LENGTH_SHORT).show()
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
        retrieveWordsDataFromBundle()
        initialiseRecyclerView()
        viewModel.initStream(this, words)
    }

    private fun retrieveWordsDataFromBundle() {
        arguments?.let {
            if (it.containsKey(WORDS_KEY)) {
                words = it.getString(WORDS_KEY, String.EMPTY)
            }
        }
    }

    private fun initialiseRecyclerView() = tweetsListRecyclerView?.let {
        it.layoutManager = LinearLayoutManager(context)
        it.setHasFixedSize(true)
        it.adapter = adapter
    }

    override fun onStatusReceived(status: Status?) {
        print(status?.text)
    }

    override fun onExemption(exception: Exception?) {
        print(exception?.localizedMessage)
    }

}