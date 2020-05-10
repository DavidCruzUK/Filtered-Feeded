package com.lastreacts.filteredfeeded.di.modules

import android.app.Application
import com.lastreacts.data.twitter.TwitterApiStreams
import com.lastreacts.filteredfeeded.BuildConfig
import com.lastreacts.filteredfeeded.data.local.TweetDao
import com.lastreacts.filteredfeeded.data.local.TweetsRoomDataBase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideTwitterApiStreams(): TwitterApiStreams = TwitterApiStreams(
        BuildConfig.CONSUMER_KEY,
        BuildConfig.CONSUMER_SECRET_KEY,
        BuildConfig.ACCESS_TOKEN,
        BuildConfig.ACCESS_SECRET_TOKEN
    )


    @Provides
    fun getMoviesDao(app: Application): TweetDao {
        return TweetsRoomDataBase.getDatabase(app).tweetDao()
    }

}