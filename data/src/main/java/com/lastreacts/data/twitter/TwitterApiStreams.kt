package com.lastreacts.data.twitter

import com.lastreacts.interfaces.StreamDataListener
import com.lastreacts.interfaces.StreamEvents
import twitter4j.FilterQuery
import twitter4j.TwitterStream
import twitter4j.TwitterStreamFactory
import twitter4j.conf.ConfigurationBuilder

class TwitterApiStreams(
    private val consumerKey: String,
    private val consumerSecretKey: String,
    private val accessToken: String,
    private val accessSecretToken: String
) : StreamDataListener {

    companion object {
        private const val SPLIT_PATTERN = ","
    }

    private lateinit var twitterStream: TwitterStream

    override fun initStream(listener: StreamEvents, words: String) {
        val wordsList = words.split(SPLIT_PATTERN).toTypedArray()

        val cb = ConfigurationBuilder().apply {
            setOAuthConsumerKey(consumerKey)
            setOAuthConsumerSecret(consumerSecretKey)
            setOAuthAccessToken(accessToken)
            setOAuthAccessTokenSecret(accessSecretToken)
        }
        twitterStream = TwitterStreamFactory(cb.build()).instance

        val filterQuery = FilterQuery()

        filterQuery.track(*wordsList)

        twitterStream.addListener(listener)

        twitterStream.filter(filterQuery)

    }

    override fun stopStream() {
        if (::twitterStream.isInitialized) {
            twitterStream.clearListeners()
        }
    }

}
