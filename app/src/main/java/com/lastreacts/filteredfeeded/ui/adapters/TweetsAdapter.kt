package com.lastreacts.filteredfeeded.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lastreacts.filteredfeeded.R
import com.lastreacts.filteredfeeded.data.local.TweetDb
import com.lastreacts.filteredfeeded.ui.viewholders.TweetsViewHolder
import kotlin.properties.Delegates

class TweetsAdapter(tweetsList: List<TweetDb> = emptyList(), private val listener: (tweet: TweetDb, position: Int) -> Unit) : RecyclerView.Adapter<TweetsViewHolder>() {

    var tweetsList: MutableList<TweetDb> by Delegates.observable(tweetsList.toMutableList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    fun addItem(text: String) {
        tweetsList.add(TweetDb(tweet = text))
        notifyItemInserted(tweetsList.size-1)
    }

    fun deleteTweetAtPosition(position: Int) {
        notifyItemRemoved(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetsViewHolder {
        return TweetsViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.row_tweet, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return tweetsList.size
    }

    override fun onBindViewHolder(holder: TweetsViewHolder, position: Int) {
        holder.bindTweets(tweetsList[position], listener, position)
    }

}
