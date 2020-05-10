package com.lastreacts.interfaces

import twitter4j.StatusListener
import twitter4j.TwitterStream

interface StreamDataListener {
    fun initStream(listener: StatusListener, words: String): TwitterStream?
}