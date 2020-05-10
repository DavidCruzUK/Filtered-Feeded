package com.lastreacts.filteredfeeded.di.modules

import com.lastreacts.data.TwitterApiStreams
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
    fun provideTweetListViewModel(twitterApiStreams: TwitterApiStreams): TweetListViewModel =
        TweetListViewModel(twitterApiStreams)

}