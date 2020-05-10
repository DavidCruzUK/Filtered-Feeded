package com.lastreacts.filteredfeeded.di.modules

import com.lastreacts.data.TwitterApiStreams
import com.lastreacts.filteredfeeded.ui.viewmodels.TweetListViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelsModule {

    @Provides
    fun provideTweetListViewModel(twitterApiStreams: TwitterApiStreams): TweetListViewModel =
        TweetListViewModel(twitterApiStreams)

}