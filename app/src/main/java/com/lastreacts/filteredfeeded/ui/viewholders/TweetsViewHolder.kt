package com.lastreacts.filteredfeeded.ui.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.lastreacts.filteredfeeded.BuildConfig
import com.lastreacts.filteredfeeded.data.local.TweetDb
import com.lastreacts.filteredfeeded.extensions.shouldDisplayCurrentTweet
import kotlinx.android.synthetic.main.row_tweet.view.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TweetsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    companion object {
        private const val CHECK_EVERY_MINUTE: Long = 60000 // 1 minute == 60k Milliseconds
    }
    private var scope = MainScope()

    fun bindTweets(
        tweet: TweetDb,
        listener: (tweet: TweetDb, position: Int) -> Unit,
        position: Int
    ) {
        with(itemView) {
            title.text = tweet.tweet

            if(BuildConfig.TWEET_HAS_TIMESPAN.toBoolean()) {
                checkTweet(tweet, listener, position)
            }
        }
    }

    private fun checkTweet(tweet: TweetDb, listener: (tweet: TweetDb, position: Int) -> Unit, position: Int) {
        scope.launch {
            while (true) {
                if (!tweet.shouldDisplayCurrentTweet()) {
                    listener(tweet, position-1)
                    stopUpdates()
                    return@launch
                }
                delay(CHECK_EVERY_MINUTE)
            }
        }
    }

    private fun stopUpdates() {
        scope.cancel()
        scope = MainScope()
    }

}