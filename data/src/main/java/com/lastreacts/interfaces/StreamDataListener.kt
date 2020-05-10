package com.lastreacts.interfaces

interface StreamDataListener {
    fun initStream(listener: StreamEvents, words: String)

    fun stopStream()
}