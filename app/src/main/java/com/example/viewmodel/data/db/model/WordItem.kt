package com.example.viewmodel.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "words")
data class WordItem(@PrimaryKey val word: String) {
    override fun toString(): String {
        return word
    }
}