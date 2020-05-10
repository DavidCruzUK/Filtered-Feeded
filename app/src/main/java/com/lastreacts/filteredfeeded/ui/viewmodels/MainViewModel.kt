package com.lastreacts.filteredfeeded.ui.viewmodels

import androidx.lifecycle.ViewModel
import com.lastreacts.data.TwitterApiStreams
import com.lastreacts.interfaces.StreamDataListener

class MainViewModel(private val streamDataListener: StreamDataListener): ViewModel() {

    fun stopStream() {
        streamDataListener.stopStream()
    }

}