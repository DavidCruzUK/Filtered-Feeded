package com.lastreacts.interfaces

import twitter4j.StallWarning
import twitter4j.StatusDeletionNotice
import twitter4j.StatusListener

interface StreamEvents : StatusListener {
    override fun onDeletionNotice(statusDeletionNotice: StatusDeletionNotice?){}
    override fun onScrubGeo(userId: Long, upToStatusId: Long){}
    override fun onStallWarning(warning: StallWarning?){}
    override fun onTrackLimitationNotice(numberOfLimitedStatuses: Int){}
}