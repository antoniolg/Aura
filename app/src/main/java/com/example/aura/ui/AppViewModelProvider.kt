package com.example.aura.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.aura.AuraApplication
import com.example.aura.ui.dashboard.DashboardViewModel
import com.example.aura.ui.detail.EntryDetailViewModel
import com.example.aura.ui.entry.EntryViewModel

/**
 * Provides Factory to create instance of ViewModel for the entire Aura app
 */
object AppViewModelProvider {
    val Factory: ViewModelProvider.Factory = viewModelFactory {
        // Initializer for DashboardViewModel
        initializer {
            DashboardViewModel(auraApplication().container.journalRepository)
        }
        // Initializer for EntryViewModel
        initializer {
            EntryViewModel(auraApplication().container.journalRepository)
        }
    }

    fun entryDetailFactory(entryId: Int): ViewModelProvider.Factory = viewModelFactory {
        initializer {
            EntryDetailViewModel(auraApplication().container.journalRepository, entryId)
        }
    }
}

/**
 * Extension function to queries for [AuraApplication] object and returns an instance of
 * [AuraApplication].
 */
fun CreationExtras.auraApplication(): AuraApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as AuraApplication)
