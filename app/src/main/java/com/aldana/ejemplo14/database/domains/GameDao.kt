package com.aldana.ejemplo14.database.domains

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aldana.ejemplo14.models.Game

@Dao
interface GameDao {

    @Query("SELECT * FROM game_table ORDER BY game_id ASC")
    fun getAllGames(): LiveData<List<Game>>

    @Query("SELECT * FROM game_table WHERE game_id = :id")
    fun getPartidoById(id: Int): LiveData<List<Game>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(game: Game)

    @Query("DELETE FROM game_table")
    fun deleteAll()
}