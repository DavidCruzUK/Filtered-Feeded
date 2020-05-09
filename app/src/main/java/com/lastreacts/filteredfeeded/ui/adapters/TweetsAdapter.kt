package com.lastreacts.filteredfeeded.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lastreacts.filteredfeeded.R
import com.lastreacts.filteredfeeded.ui.viewholders.TweetsViewHolder
import kotlin.properties.Delegates

class TweetsAdapter(tweetsList: List<String> = emptyList(), private val listener: (id: Int) -> Unit) : RecyclerView.Adapter<TweetsViewHolder>() {

    var tweetsList: List<String> by Delegates.observable(tweetsList) { _, _, _ ->
        notifyDataSetChanged()
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
        holder.bindTweets(tweetsList[position], position, listener)
    }

}