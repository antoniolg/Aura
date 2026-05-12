package com.example.aura.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [JournalEntry::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class AuraDatabase : RoomDatabase() {
    abstract fun journalDao(): JournalDao

    companion object {
        @Volatile
        private var Instance: AuraDatabase? = null

        fun getDatabase(context: Context): AuraDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AuraDatabase::class.java, "aura_database")
                    .fallbackToDestructiveMigration(true)
                    .build()
                    .also { Instance = it }
            }
        }
    }
}
