package com.example.notes_app_viewmodel

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface NoteDao {

    @Insert
    suspend fun addNote(note: Notes)

    @Query("SELECT * FROM notes ORDER BY pk ASC")
    fun getNote(): LiveData<List<Notes>> //added the live data to observe if there is any changes


    @Update
    suspend fun updateNote(note:Notes)

    @Delete
    suspend fun deleteNote(note:Notes)
}