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

class ScoreViewModel(application: Application) : AndroidViewModel(application) {
    var scoreTeamA = ObservableField<String>()
    var scoreTeamB = ObservableField<String>()

    private val repository: GameRepository
    val allGames: LiveData<List<Game>>

    init {
        val gamesDao = MainDatabase.getDatabase(application).gameDao()
        repository = GameRepository(gamesDao)
        allGames = repository.allGames
    }

    fun insert(game: Game) = viewModelScope.launch(Dispatchers.IO) { repository.insert(game) }
}