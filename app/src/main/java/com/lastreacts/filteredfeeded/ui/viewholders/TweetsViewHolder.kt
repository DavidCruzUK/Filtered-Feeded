package com.lastreacts.filteredfeeded.ui.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_tweet.view.*

class TweetsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bindTweets(
        tweet: String,
        position: Int,
        listener: (position: Int) -> Unit
    ) {
        with(itemView) {
            title.text = tweet

            setOnClickListener {
                listener(position)
            }
        }
    }

}