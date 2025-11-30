package com.example.starengine.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "upgrades")
data class Upgrade(
    @PrimaryKey
    val id: Int = 1,
    val speed: Float = 1.0f,
    val fireRate: Float = 1.0f,
    val power: Int = 1,
    val shipWidth: Float = 1.0f
)

