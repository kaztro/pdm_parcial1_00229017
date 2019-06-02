package com.aldana.ejemplo14

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.aldana.ejemplo14.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var scoreViewModel = ScoreViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(savedInstanceState != null){
            scoreViewModel.scoreTeamA.set(savedInstanceState.getString(AppConstants.SCORE_A))
            scoreViewModel.scoreTeamB.set(savedInstanceState.getString(AppConstants.SCORE_B))
        } else {
            scoreViewModel.scoreTeamA.set("0")
            scoreViewModel.scoreTeamB.set("0")
        }

        var dataBinding : ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        dataBinding.score = scoreViewModel

    }

    fun addScore(view : View){
        when(view.id){
            R.id.bt_team_a_free_throw -> scoreViewModel.scoreTeamA.set((scoreViewModel.scoreTeamA.get()!!.toInt()+1).toString())
            R.id.bt_team_a_2_p -> scoreViewModel.scoreTeamA.set((scoreViewModel.scoreTeamA.get()!!.toInt()+2).toString())
            R.id.bt_team_a_3_p -> scoreViewModel.scoreTeamA.set((scoreViewModel.scoreTeamA.get()!!.toInt()+3).toString())
            R.id.bt_team_b_free_throw -> scoreViewModel.scoreTeamB.set((scoreViewModel.scoreTeamB.get()!!.toInt()+1).toString())
            R.id.bt_team_b_2_p -> scoreViewModel.scoreTeamB.set((scoreViewModel.scoreTeamB.get()!!.toInt()+2).toString())
            R.id.bt_team_b_3_p -> scoreViewModel.scoreTeamB.set((scoreViewModel.scoreTeamB.get()!!.toInt()+3).toString())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(AppConstants.SCORE_A, scoreViewModel.scoreTeamA.get())
        outState.putString(AppConstants.SCORE_B, scoreViewModel.scoreTeamB.get())
    }

    fun resetScore(view : View) {
        with(scoreViewModel) {
            scoreTeamA.set("0")
            scoreTeamB.set("0")
        }
    }
}



