package com.example.aura.ui.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface Destination : NavKey {
    @Serializable
    data object Dashboard : Destination

    @Serializable
    data object NewEntry : Destination
    
    @Serializable
    data class EntryDetail(val entryId: Int) : Destination
}
