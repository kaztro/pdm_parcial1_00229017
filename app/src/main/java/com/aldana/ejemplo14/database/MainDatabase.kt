package com.aldana.ejemplo14.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.aldana.ejemplo14.database.domains.GameDao
import com.aldana.ejemplo14.models.Game
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Game::class], version = 1, exportSchema = false)
abstract class MainDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao

    companion object {
        @Volatile
        private var INSTANCE: MainDatabase? = null

        fun getDatabase(context: Context,
                        scope: CoroutineScope): MainDatabase {
            if (INSTANCE == null) {
                synchronized(MainDatabase::class) {
                    INSTANCE = Room
                        .databaseBuilder(context.applicationContext,
                        MainDatabase::class.java,
                        "Game_database")
                        .addCallback(MainDatabaseCallback(scope))
                        .build()
            }
            }
            return INSTANCE!!
        }

        private class MainDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback(){
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database -> scope.launch(Dispatchers.IO){
                    populateDatabase(database.gameDao())
                } }
            }
        }

        suspend fun populateDatabase(gameDao: GameDao) {

            gameDao.deleteAll()

            var game = Game("LA",23, "Lakers",20)
            gameDao.insert(game)

        }
    }

}