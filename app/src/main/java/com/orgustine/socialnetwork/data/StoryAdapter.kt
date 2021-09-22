package com.orgustine.socialnetwork.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.orgustine.socialnetwork.databinding.StoryItemLayoutBinding

class StoryAdapter : ListAdapter<Story, StoryAdapter.StoryViewHolder>(DiffCallbck()) {

    inner class StoryViewHolder(private val binding: StoryItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(story: Story) {
            binding.apply {
                storyIv.setImageResource(story.image)
                usernameTv.text = story.username
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val binding =
            StoryItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }
}

class DiffCallbck : DiffUtil.ItemCallback<Story>() {
    override fun areItemsTheSame(oldItem: Story, newItem: Story) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Story, newItem: Story) =
        oldItem == newItem
}