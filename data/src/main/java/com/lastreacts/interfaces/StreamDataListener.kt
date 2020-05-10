package com.lastreacts.interfaces

import twitter4j.StatusListener

interface StreamDataListener {
    fun initStream(listener: StatusListener, words: String)

    fun stopStream()
}