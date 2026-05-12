package com.example.aura.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Mood
import androidx.compose.material.icons.rounded.MoodBad
import androidx.compose.material.icons.rounded.SentimentDissatisfied
import androidx.compose.material.icons.rounded.SentimentNeutral
import androidx.compose.material.icons.rounded.SentimentSatisfied
import androidx.compose.ui.graphics.vector.ImageVector

enum class Mood(val displayName: String, val icon: ImageVector) {
    HAPPY("Happy", Icons.Rounded.Mood),
    CALM("Calm", Icons.Rounded.SentimentSatisfied),
    NEUTRAL("Neutral", Icons.Rounded.SentimentNeutral),
    SAD("Sad", Icons.Rounded.SentimentDissatisfied),
    ANXIOUS("Anxious", Icons.Rounded.MoodBad)
}
