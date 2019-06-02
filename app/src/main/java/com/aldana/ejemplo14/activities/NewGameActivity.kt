package com.aldana.ejemplo14.activities

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import com.aldana.ejemplo14.R
import com.aldana.ejemplo14.constants.AppConstants
import com.aldana.ejemplo14.databinding.ActivityMainBinding
import com.aldana.ejemplo14.viewmodels.GameViewModel
import kotlinx.android.synthetic.main.activity_new_game.*

class NewGameActivity : AppCompatActivity() {

    private var scoreViewModel = GameViewModel()
    private lateinit var editATeamView: EditText
    private lateinit var editBTeamView: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var dataBinding : ActivityMainBinding = DataBindingUtil
            .setContentView(this, R.layout.activity_new_game )

        dataBinding.score = scoreViewModel
            with(scoreViewModel) {
                scoreTeamA.set("0")
                scoreTeamB.set("0")
            }

        editATeamView = findViewById(R.id.et_a_team)
        editBTeamView = findViewById(R.id.et_b_team)

        val button = findViewById<Button>(R.id.bt_save)

        button.setOnClickListener {
            val replyIntent = Intent()
            if(TextUtils.isEmpty(editATeamView.text)
                || TextUtils.isEmpty(editBTeamView.text)
                || scoreViewModel.scoreTeamA.get().equals("0")
                || scoreViewModel.scoreTeamB.get().equals("0")) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val game1 = editATeamView.text.toString()
                val game2 = editBTeamView.text.toString()


            }

        }
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
        with(outState) {
            putString(AppConstants.SCORE_A, scoreViewModel.scoreTeamA.get())
            putString(AppConstants.SCORE_B, scoreViewModel.scoreTeamB.get())
        }
    }

    fun resetScore(view : View) {
        with(scoreViewModel) {
            scoreTeamA.set("0")
            scoreTeamB.set("0")
        }
    }
}
