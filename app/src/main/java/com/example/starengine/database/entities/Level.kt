package com.example.starengine.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "levels")
data class Level(
    @PrimaryKey
    val levelNumber: Int,
    val difficultySpeed: Float,
    val alienRate: Float
)

