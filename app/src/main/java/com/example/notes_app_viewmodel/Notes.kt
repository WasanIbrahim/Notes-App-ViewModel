package com.example.notes_app_viewmodel

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "notes")
data class Notes(
    @PrimaryKey(autoGenerate = true) val pk: Int,
    val note: String
)