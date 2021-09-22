package com.orgustine.socialnetwork.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.orgustine.socialnetwork.R
import com.orgustine.socialnetwork.data.FeedAdapter.FeedViewHolder
import com.orgustine.socialnetwork.databinding.FeedListItemBinding

class FeedAdapter(private val listener: OnItemClickListener) :
    ListAdapter<Feed, FeedViewHolder>(DiffCallback()) {

    inner class FeedViewHolder(private val binding: FeedListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(feed: Feed) {
            binding.apply {
                feedImg.setImageResource(feed.image)
                nameTv.text = feed.username
                timeTv.text = feed.time
                postTv.text = feed.post
                likesTv.text = feed.likes.toString()
                commentsTv.text = root.context.getString(
                    R.string.dummy_comment,feed.comments.toString())
                sharesTv.text = root.context.getString(
                    R.string.dummy_shares,feed.shares.toString())
                root.setOnClickListener {
                    if (adapterPosition != RecyclerView.NO_POSITION) {
                        listener.onItemClick(adapterPosition)
                    }
                }
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val binding =
            FeedListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }
}

interface OnItemClickListener {
    fun onItemClick(id: Int)
}

class DiffCallback : DiffUtil.ItemCallback<Feed>() {
    override fun areItemsTheSame(oldItem: Feed, newItem: Feed) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Feed, newItem: Feed) =
        oldItem == newItem
}
