package com.lastreacts.filteredfeeded.di.modules

import com.lastreacts.data.twitter.TwitterApiStreams
import com.lastreacts.filteredfeeded.data.local.TweetDao
import com.lastreacts.filteredfeeded.ui.viewmodels.MainViewModel
import com.lastreacts.filteredfeeded.ui.viewmodels.TweetListViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelsModule {

    @Provides
    fun provideMainViewModel(twitterApiStreams: TwitterApiStreams): MainViewModel =
        MainViewModel(twitterApiStreams)

    @Provides
    fun provideTweetListViewModel(
        twitterApiStreams: TwitterApiStreams,
        tweetDao: TweetDao
    ): TweetListViewModel =
        TweetListViewModel(twitterApiStreams, tweetDao)

}