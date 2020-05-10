package com.lastreacts.filteredfeeded.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tweets")
data class TweetDb(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val tweet: String,
    val date: Long = System.currentTimeMillis()
)