package com.aldana.ejemplo14.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "game_table")
data class Game (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "game_id")
    val gameId: Int,

    @ColumnInfo(name = "a_team")
    val aTeam: String,
    @ColumnInfo(name = "a_team_score")
    val aScore: String,

    @ColumnInfo(name = "b_team")
    val bTeam: String,
    @ColumnInfo(name = "b_team_score")
    val bScore: String
)