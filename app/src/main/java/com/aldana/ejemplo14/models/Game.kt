package com.aldana.ejemplo14.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game_table")
data class Game (

    @ColumnInfo(name = "a_team")
    val aTeam: String,
    @ColumnInfo(name = "a_team_score")
    val aScore: Int,

    @ColumnInfo(name = "b_team")
    val bTeam: String,
    @ColumnInfo(name = "b_team_score")
    val bScore: Int
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "game_id")
    var gameId: Int = 0
}