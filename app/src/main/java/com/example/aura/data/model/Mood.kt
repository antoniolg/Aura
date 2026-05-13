package com.example.aura.data.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Mood
import androidx.compose.material.icons.rounded.MoodBad
import androidx.compose.material.icons.rounded.SentimentDissatisfied
import androidx.compose.material.icons.rounded.SentimentNeutral
import androidx.compose.material.icons.rounded.SentimentSatisfied
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

enum class Mood(val displayName: String, val icon: ImageVector, val color: Color) {
    HAPPY("Happy", Icons.Rounded.Mood, Color(0xFFFFD700)),
    CALM("Calm", Icons.Rounded.SentimentSatisfied, Color(0xFF98FB98)),
    NEUTRAL("Neutral", Icons.Rounded.SentimentNeutral, Color(0xFFADD8E6)),
    SAD("Sad", Icons.Rounded.SentimentDissatisfied, Color(0xFFB0C4DE)),
    ANXIOUS("Anxious", Icons.Rounded.MoodBad, Color(0xFFFFB6C1))
}
