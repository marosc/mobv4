package com.example.viewmodel.data.db.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "images")
data class VideoItem(
    @PrimaryKey val id: String,
    val userid: String,
    val image_title: String,
    val image_url: String,
    val image_tags: List<String>,
    @Embedded
    val image_location: VideoLocation
)

data class VideoLocation(
    val lon: Float,
    val lat: Float
)