package com.aldana.ejemplo14.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.aldana.ejemplo14.database.domains.GameDao
import com.aldana.ejemplo14.models.Game

@Database(entities = [Game::class], version = 1, exportSchema = false)
abstract class MainDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao

    companion object {
        @Volatile
        private var INSTANCE: MainDatabase? = null

        fun getDatabase(context: Context): MainDatabase {
            if (INSTANCE == null) {
                synchronized(MainDatabase::class) {
                    INSTANCE = Room
                        .databaseBuilder(context.applicationContext,
                        MainDatabase::class.java,
                        "Game_database")
                        .build()
            }
            }
            return INSTANCE!!
        }
    }
}