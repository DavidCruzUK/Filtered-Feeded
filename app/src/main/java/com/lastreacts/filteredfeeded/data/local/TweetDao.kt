package com.lastreacts.filteredfeeded.data.local

import androidx.room.*

@Dao
interface TweetDao {
    @Query("DELETE FROM tweets")
    fun deleteAllTweets()

    @Query("SELECT * FROM tweets ORDER BY id")
    fun getListOfTweets(): List<TweetDb>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTweet(tweet: TweetDb)

    @Delete
    fun deleteTweet(tweet: TweetDb)

}