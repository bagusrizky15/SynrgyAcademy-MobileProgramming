package com.example.challengechapter4.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note (
    @PrimaryKey(autoGenerate = true)
    val noteId: Long? = null,

    val title: String,
    val content:String,
    val timeStamp: Int
    )

