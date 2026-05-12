package com.example.aura.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.aura.data.model.Mood

@Entity(tableName = "journal_entries")
data class JournalEntry(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val content: String,
    val timestamp: Long,
    val mood: Mood
)
