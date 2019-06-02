package com.aldana.ejemplo14.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aldana.ejemplo14.R
import com.aldana.ejemplo14.adapters.GameListAdapter
import com.aldana.ejemplo14.viewmodels.GameViewModel

class MainActivity : AppCompatActivity() {

    private var scoreViewModel = GameViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        val adapter = GameListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

}


