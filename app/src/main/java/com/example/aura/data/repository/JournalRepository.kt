package com.example.aura.data.repository

import com.example.aura.data.local.JournalDao
import com.example.aura.data.local.JournalEntry
import kotlinx.coroutines.flow.Flow

class JournalRepository(private val journalDao: JournalDao) {
    fun getAllEntries(): Flow<List<JournalEntry>> = journalDao.getAllEntries()

    suspend fun getEntryById(id: Int): JournalEntry? = journalDao.getEntryById(id)

    suspend fun insertEntry(entry: JournalEntry) = journalDao.insertEntry(entry)

    suspend fun updateEntry(entry: JournalEntry) = journalDao.updateEntry(entry)

    suspend fun deleteEntry(entry: JournalEntry) = journalDao.deleteEntry(entry)
}
