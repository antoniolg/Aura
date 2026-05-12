package com.example.aura.data.local

import androidx.room.TypeConverter
import com.example.aura.data.model.Mood

class Converters {
    @TypeConverter
    fun fromMood(mood: Mood): String {
        return mood.name
    }

    @TypeConverter
    fun toMood(value: String): Mood {
        return Mood.valueOf(value)
    }
}
