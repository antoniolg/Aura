package com.example.aura.data.repository

import com.example.aura.data.local.JournalDao
import com.example.aura.data.local.JournalEntry
import com.example.aura.data.model.Mood
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

class JournalRepositoryTest {

    private lateinit var journalDao: JournalDao
    private lateinit var journalRepository: JournalRepository

    private val sampleEntry = JournalEntry(
        id = 1,
        title = "Test Title",
        content = "Test Content",
        timestamp = 123456789L,
        mood = Mood.HAPPY
    )

    @Before
    fun setUp() {
        journalDao = mock()
        journalRepository = JournalRepository(journalDao)
    }

    @Test
    fun `getAllEntries calls journalDao getAllEntries`() = runTest {
        val entries = listOf(sampleEntry)
        whenever(journalDao.getAllEntries()).thenReturn(flowOf(entries))

        val result = journalRepository.getAllEntries().first()

        assertEquals(entries, result)
        verify(journalDao).getAllEntries()
    }

    @Test
    fun `getEntryById calls journalDao getEntryById`() = runTest {
        whenever(journalDao.getEntryById(1)).thenReturn(sampleEntry)

        val result = journalRepository.getEntryById(1)

        assertEquals(sampleEntry, result)
        verify(journalDao).getEntryById(1)
    }

    @Test
    fun `insertEntry calls journalDao insertEntry`() = runTest {
        journalRepository.insertEntry(sampleEntry)
        verify(journalDao).insertEntry(sampleEntry)
    }

    @Test
    fun `updateEntry calls journalDao updateEntry`() = runTest {
        journalRepository.updateEntry(sampleEntry)
        verify(journalDao).updateEntry(sampleEntry)
    }

    @Test
    fun `deleteEntry calls journalDao deleteEntry`() = runTest {
        journalRepository.deleteEntry(sampleEntry)
        verify(journalDao).deleteEntry(sampleEntry)
    }
}
