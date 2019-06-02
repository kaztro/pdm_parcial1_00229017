package com.aldana.ejemplo14.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aldana.ejemplo14.R
import com.aldana.ejemplo14.models.Game

class GameListAdapter internal constructor(
    context: Context
) : RecyclerView.Adapter<GameListAdapter.GameViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var games = emptyList<Game>()

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gameItemView: TextView = itemView.findViewById(R.id.tv_game)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return GameViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val current = games[position]
        holder.gameItemView.text = current.aTeam + "VS" + current.bTeam
    }

    internal fun setWords(games: List<Game>) {
        this.games = games
        notifyDataSetChanged()
    }

    override fun getItemCount() = games.size
}