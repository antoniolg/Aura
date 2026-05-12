package com.example.aura.ui.entry

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.aura.data.local.JournalEntry
import com.example.aura.data.model.Mood
import com.example.aura.data.repository.JournalRepository
import java.util.Date

class EntryViewModel(private val journalRepository: JournalRepository) : ViewModel() {

    var entryUiState by mutableStateOf(EntryUiState())
        private set

    fun updateUiState(entryDetails: EntryDetails) {
        entryUiState = EntryUiState(entryDetails = entryDetails, isEntryValid = validateInput(entryDetails))
    }

    suspend fun saveEntry() {
        if (validateInput(entryUiState.entryDetails)) {
            journalRepository.insertEntry(entryUiState.entryDetails.toJournalEntry())
        }
    }

    private fun validateInput(uiState: EntryDetails = entryUiState.entryDetails): Boolean {
        return with(uiState) {
            title.isNotBlank() && content.isNotBlank()
        }
    }
}

data class EntryUiState(
    val entryDetails: EntryDetails = EntryDetails(),
    val isEntryValid: Boolean = false
)

data class EntryDetails(
    val id: Int = 0,
    val title: String = "",
    val content: String = "",
    val timestamp: Long = Date().time,
    val mood: Mood = Mood.HAPPY
)

fun EntryDetails.toJournalEntry(): JournalEntry = JournalEntry(
    id = id,
    title = title,
    content = content,
    timestamp = timestamp,
    mood = mood
)
