package com.aldana.ejemplo14.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.aldana.ejemplo14.database.domains.GameDao
import com.aldana.ejemplo14.models.Game

class GameRepository(private val gameDao: GameDao) {

    fun allGames(): LiveData<List<Game>> = gameDao.getAllGames()

    @WorkerThread
    suspend fun insert(game: Game) = gameDao.insert(game)

    @WorkerThread
    suspend fun delete() = gameDao.deleteAll()

    fun  getGameById(id:Int): LiveData<List<Game>> = gameDao.getPartidoById(id)
}