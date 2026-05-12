package com.example.aura

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.navigation3.ListDetailSceneStrategy
import androidx.compose.material3.adaptive.navigation3.rememberListDetailSceneStrategy
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.aura.ui.dashboard.DashboardScreen
import com.example.aura.ui.detail.EntryDetailScreen
import com.example.aura.ui.entry.EntryScreen
import com.example.aura.ui.navigation.Destination
import com.example.aura.ui.theme.AuraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AuraTheme {
                AuraApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun AuraApp() {
    val backStack = rememberNavBackStack(Destination.Dashboard as NavKey)
    val listDetailStrategy = rememberListDetailSceneStrategy<NavKey>()
    
    NavDisplay(
        backStack = backStack,
        modifier = Modifier.fillMaxSize(),
        onBack = { if (backStack.size > 1) backStack.removeAt(backStack.size - 1) },
        sceneStrategy = listDetailStrategy,
        entryProvider = entryProvider {
            entry<Destination.Dashboard>(
                metadata = ListDetailSceneStrategy.listPane(
                    sceneKey = "dashboard",
                    detailPlaceholder = {
                        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            Text(
                                text = "Select an entry to view details",
                                style = MaterialTheme.typography.titleMedium,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                )
            ) {
                DashboardScreen(
                    navigateToEntryEntry = { backStack.add(Destination.NewEntry) },
                    onEntryClick = { backStack.add(Destination.EntryDetail(it)) }
                )
            }
            entry<Destination.NewEntry>(
                metadata = ListDetailSceneStrategy.detailPane(sceneKey = "new_entry")
            ) {
                EntryScreen(
                    navigateBack = { backStack.removeAt(backStack.size - 1) },
                    onNavigateUp = { backStack.removeAt(backStack.size - 1) }
                )
            }
            entry<Destination.EntryDetail>(
                metadata = ListDetailSceneStrategy.detailPane(sceneKey = "entry_detail")
            ) { key: Destination.EntryDetail ->
                EntryDetailScreen(
                    entryId = key.entryId,
                    onNavigateUp = { backStack.removeAt(backStack.size - 1) }
                )
            }
        },
        entryDecorators = listOf<NavEntryDecorator<NavKey>>(
            rememberSaveableStateHolderNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        )
    )
}
