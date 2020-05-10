package com.lastreacts.filteredfeeded.ui.interfaces

import twitter4j.Status
import java.lang.Exception

interface StreamEventsImpl {
    fun onStatusReceived(status: Status?)
    fun onExemption(exception: Exception?)
}