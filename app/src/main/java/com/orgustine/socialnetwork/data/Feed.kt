package com.orgustine.socialnetwork.data

import com.orgustine.socialnetwork.R

data class Feed(
    val id: Long,
    val username: String,
    val time: String,
    val post: String,
    val likes: Int,
    val shares: Int,
    val comments: Int,
    val image: Int = R.drawable.profile_img,
)