package com.lastreacts.data

import com.lastreacts.interfaces.StreamDataListener
import twitter4j.FilterQuery
import twitter4j.StatusListener
import twitter4j.TwitterStream
import twitter4j.TwitterStreamFactory
import twitter4j.conf.ConfigurationBuilder

class TwitterApiStreams : StreamDataListener{

    companion object {
        private const val consumerKeyValue = "myj9bbBcrfNS4YQ0XFm4156qG"
        private const val consumerKeySecretValue =
            "5CgA0l7gGDbsXVzvMAywT0BaZ7eYSwLIwvfS34gMmZVWZHIp6f"
        private const val accessTokenValue = "1000837614541398017-FwaUrGSwu9vSbT8yiEeAmnyiqJRnvG"
        private const val accessTokenSecretValue = "gytiF01wwYNRzHddkdkSntt3afOqR8NfIXh2yUJC0ZNkn"

        private const val SPLIT_PATTERN = ","
    }

    private lateinit var twitterStream: TwitterStream

    override fun initStream(listener: StatusListener, words: String) {
        val wordsList = words.split(SPLIT_PATTERN).toTypedArray()

        val cb = ConfigurationBuilder().apply {
            setOAuthConsumerKey(consumerKeyValue)
            setOAuthConsumerSecret(consumerKeySecretValue)
            setOAuthAccessToken(accessTokenValue)
            setOAuthAccessTokenSecret(accessTokenSecretValue)
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
