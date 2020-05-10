package com.lastreacts.filteredfeeded.extensions

import com.lastreacts.filteredfeeded.BuildConfig
import com.lastreacts.filteredfeeded.data.local.TweetDb

fun TweetDb.shouldDisplayCurrentTweet(): Boolean {
    return (date + BuildConfig.TWEET_TIMESPAN.toLong()) > System.currentTimeMillis()
}