package com.lastreacts.filteredfeeded.di.modules

import com.lastreacts.filteredfeeded.ui.viewmodels.TweetListViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelsModule {

    @Provides
    fun provideTweetListViewModel(): TweetListViewModel = TweetListViewModel()

}