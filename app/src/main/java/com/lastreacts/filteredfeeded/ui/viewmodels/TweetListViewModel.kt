package com.lastreacts.filteredfeeded.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.lastreacts.data.TwitterApiStreams
import com.lastreacts.filteredfeeded.ui.interfaces.StreamEventsImpl
import com.lastreacts.interfaces.StreamEvents
import twitter4j.Status

class TweetListViewModel(private val streamDataListener: TwitterApiStreams) : ViewModel(),
    StreamEvents {

    lateinit var listener: StreamEventsImpl


    fun initStream(listener: StreamEventsImpl, words: String) {
        this.listener = listener
        streamDataListener.initStream(this, words)
    }

    override fun onException(ex: Exception?) {
        // TODO: implement error Handling for Stream
        print(ex?.localizedMessage)
        if (::listener.isInitialized) {
            listener.onExemption(ex)
        }
    }

    override fun onStatus(status: Status?) {
        // TODO: implement List Update
        print(status?.text)
        if (::listener.isInitialized) {
            listener.onStatusReceived(status)
        }
    }

}