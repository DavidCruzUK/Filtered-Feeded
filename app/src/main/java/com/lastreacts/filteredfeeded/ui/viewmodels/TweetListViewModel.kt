package com.lastreacts.filteredfeeded.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lastreacts.filteredfeeded.data.local.TweetDao
import com.lastreacts.filteredfeeded.data.local.TweetDb
import com.lastreacts.filteredfeeded.extensions.shouldDisplayCurrentTweet
import com.lastreacts.interfaces.StreamDataListener
import com.lastreacts.interfaces.StreamEvents
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import twitter4j.Status

class TweetListViewModel(
    private val streamDataListener: StreamDataListener,
    private val tweetDao: TweetDao
) : ViewModel(),
    StreamEvents {

    sealed class UiModel {
        data class AddTweet(val tweet: String) : UiModel()
        data class OnError(val error: String) : UiModel()
        data class Content(val tweets: List<TweetDb>) : UiModel()
        data class DeleteTweet(val position: Int) : UiModel()
    }

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel> get() = _model

    private var isStreamStarted = true

    suspend fun initStream(words: String) = withContext(Dispatchers.IO) {
        streamDataListener.initStream(this@TweetListViewModel, words)
    }

    suspend fun showCurrentListOfTweets() = withContext(Dispatchers.IO) {
        _model.postValue(UiModel.Content(tweetDao.getListOfTweets().filter {
            it.shouldDisplayCurrentTweet()
        }))
    }

    override fun onException(ex: Exception?) {
        ex?.let {
            _model.postValue(UiModel.OnError(it.localizedMessage!!))
        }
    }

    override fun onStatus(status: Status?) {
        deleteAllTweetsWhenStreamingStartsSuccessful()
        print(status?.text)
        status?.let {
            val tweet = TweetDb(tweet = status.text)
            tweetDao.insertTweet(tweet)
            _model.postValue(UiModel.AddTweet(status.text))
        }
    }

    suspend fun deleteTweet(tweetDb: TweetDb, position: Int) = withContext(Dispatchers.IO) {
        tweetDao.deleteTweet(tweetDb)
        _model.postValue(UiModel.DeleteTweet(position))
    }

    private fun deleteAllTweetsWhenStreamingStartsSuccessful() {
        if (isStreamStarted) {
            tweetDao.deleteAllTweets()
            isStreamStarted = false
        }
    }

}