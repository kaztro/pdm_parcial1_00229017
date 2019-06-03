package com.aldana.ejemplo14.viewmodels

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.aldana.ejemplo14.database.MainDatabase
import com.aldana.ejemplo14.models.Game
import com.aldana.ejemplo14.repository.GameRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GameViewModel(application: Application) : AndroidViewModel(application) {
    private var gameRepository: GameRepository? = null

    init {
        val gameDao = MainDatabase.getDatabase(application, viewModelScope).gameDao()
        gameRepository = GameRepository(gameDao)
    }

    fun insertGame(game: Game) = viewModelScope.launch(Dispatchers.IO){
        gameRepository!!.insert(game)
    }

    fun getAllGames(): LiveData<List<Game>> = gameRepository!!.allGames()
}