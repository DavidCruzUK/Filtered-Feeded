package com.lastreacts.interfaces

import twitter4j.StallWarning
import twitter4j.StatusDeletionNotice
import twitter4j.StatusListener

interface StreamEvents : StatusListener {
    override fun onDeletionNotice(statusDeletionNotice: StatusDeletionNotice?) {
        print("onDeletionNotice -> ${statusDeletionNotice?.statusId}")
    }
    override fun onScrubGeo(userId: Long, upToStatusId: Long) {
        print("onScrubGeo -> UserId: $userId StatusId: $upToStatusId")
    }
    override fun onStallWarning(warning: StallWarning?) {
        print("onStallWarning -> Warning: $warning")
    }
    override fun onTrackLimitationNotice(numberOfLimitedStatuses: Int) {
        print("onTrackLimitationNotice -> Limited Statuses Number: $numberOfLimitedStatuses")
    }
}