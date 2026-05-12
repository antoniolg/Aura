package com.example.aura.data

import android.content.Context
import com.example.aura.data.local.AuraDatabase
import com.example.aura.data.repository.JournalRepository

/**
 * Dependency Injection container at the application level.
 */
interface AppContainer {
    val journalRepository: JournalRepository
}

/**
 * [AppContainer] implementation that provides instance of [JournalRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [JournalRepository]
     */
    override val journalRepository: JournalRepository by lazy {
        JournalRepository(AuraDatabase.getDatabase(context).journalDao())
    }
}
