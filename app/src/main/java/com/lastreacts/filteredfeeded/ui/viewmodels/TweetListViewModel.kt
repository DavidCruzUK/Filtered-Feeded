package com.lastreacts.filteredfeeded.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.lastreacts.data.TwitterApiStreams
import com.lastreacts.filteredfeeded.ui.interfaces.StreamEventsImpl
import com.lastreacts.interfaces.StreamEvents
import twitter4j.StallWarning
import twitter4j.Status
import twitter4j.StatusDeletionNotice

class TweetListViewModel(private val streamDataListener: TwitterApiStreams) : ViewModel(),
    StreamEvents {

    lateinit var listener: StreamEventsImpl


    fun initStream(listener: StreamEventsImpl, words: String) {
        this.listener = listener
        streamDataListener.initStream(this, words)
    }

    override fun onTrackLimitationNotice(numberOfLimitedStatuses: Int) {
        print(numberOfLimitedStatuses)
    }

    override fun onStallWarning(warning: StallWarning?) {
        print(warning?.message)
    }

    override fun onException(ex: Exception?) {
        // TODO: implement error Handling for Stream
        print(ex?.localizedMessage)
        if (::listener.isInitialized) {
            listener.onExemption(ex)
        }
    }

    override fun onDeletionNotice(statusDeletionNotice: StatusDeletionNotice?) {
        print(statusDeletionNotice?.statusId)
    }

    override fun onStatus(status: Status?) {
        // TODO: implement List Update
        print(status?.text)
        if (::listener.isInitialized) {
            listener.onStatusReceived(status)
        }
    }

    override fun onScrubGeo(userId: Long, upToStatusId: Long) {
        print(userId)
    }

    fun onStop() {
        streamDataListener.onStop()
    }

}