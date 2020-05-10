package com.lastreacts.filteredfeeded.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TweetDb::class], version = 1)
abstract class TweetsRoomDataBase : RoomDatabase() {
    abstract fun tweetDao(): TweetDao

    companion object {
        @Volatile
        private var INSTANCE: TweetsRoomDataBase? = null

        fun getDatabase(context: Context): TweetsRoomDataBase {
            return INSTANCE
                ?: synchronized(this) {
                    // Create database here
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        TweetsRoomDataBase::class.java,
                        "tweets_database"
                    ).build()
                    INSTANCE = instance
                    instance
                }
        }
    }
}