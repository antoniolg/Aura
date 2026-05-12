package com.example.aura.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aura.data.local.JournalEntry
import com.example.aura.data.repository.JournalRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn

data class EntryDetailUiState(val entry: JournalEntry? = null)

class EntryDetailViewModel(
    private val journalRepository: JournalRepository,
    private val entryId: Int
) : ViewModel() {
    val uiState: StateFlow<EntryDetailUiState> = flow {
        emit(EntryDetailUiState(journalRepository.getEntryById(entryId)))
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = EntryDetailUiState()
    )
}
