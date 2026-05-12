package com.example.aura.ui.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aura.data.local.JournalEntry
import com.example.aura.data.repository.JournalRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

data class DashboardUiState(val entryList: List<JournalEntry> = listOf())

class DashboardViewModel(journalRepository: JournalRepository) : ViewModel() {
    val dashboardUiState: StateFlow<DashboardUiState> =
        journalRepository.getAllEntries().map { DashboardUiState(it) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = DashboardUiState()
            )

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}
