package com.lastreacts.filteredfeeded.di.modules

import com.lastreacts.data.TwitterApiStreams
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideTwitterApiStreams(): TwitterApiStreams = TwitterApiStreams()

}