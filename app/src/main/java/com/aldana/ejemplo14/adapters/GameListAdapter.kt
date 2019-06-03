package com.aldana.ejemplo14.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aldana.ejemplo14.R
import com.aldana.ejemplo14.activities.GameDTO
import com.aldana.ejemplo14.models.Game
import kotlinx.android.synthetic.main.recyclerview_item.view.*

class GameListAdapter (context: Context, val clickListener: (GameDTO) -> Unit) : RecyclerView.Adapter<GameListAdapter.GameViewHolder>(){

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var games = emptyList<GameDTO>()

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(item: GameDTO,clickListener: (GameDTO) -> Unit) = with(itemView){
            tv_game.text = item.equipoA + " vs " + item.equipoB
            this.setOnClickListener { clickListener(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, parent, false)
        return GameViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val current = games[position]
        holder.bind(current, clickListener)
    }

    internal fun setGame(games: List<GameDTO>) {
        this.games = games
        notifyDataSetChanged()
    }

    override fun getItemCount() = games.size
}