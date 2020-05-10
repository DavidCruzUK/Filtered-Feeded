package com.lastreacts.filteredfeeded.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lastreacts.data.TwitterApiStreams
import com.lastreacts.interfaces.StreamDataListener
import com.lastreacts.interfaces.StreamEvents
import twitter4j.Status

class TweetListViewModel(private val streamDataListener: StreamDataListener) : ViewModel(),
    StreamEvents {

    sealed class UiModel {
        data class AddTweet(val tweet: String): UiModel()
        data class OnError(val error: String): UiModel()
    }

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel> get() = _model

    var listOfTweets: MutableList<String> = mutableListOf()

    fun initStream(words: String) {
        streamDataListener.initStream(this, words)
    }

    override fun onException(ex: Exception?) {
        // TODO: implement error Handling for Stream
        ex?.let {
            _model.postValue(UiModel.OnError(it.localizedMessage!!))
        }
    }

    override fun onStatus(status: Status?) {
        // TODO: implement List Update
        print(status?.text)
        status?.let {
            listOfTweets.add(it.text)
            _model.postValue(UiModel.AddTweet(status.text))
        }
    }

}