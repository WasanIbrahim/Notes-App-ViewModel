package com.example.notes_app_viewmodel

import androidx.lifecycle.LiveData

class NoteRepository(private val noteDao: NoteDao) {

     val getNote: LiveData<List<Notes>> = noteDao.getNote()

    suspend fun addNote(note:Notes){
        noteDao.addNote(note)
    }

    suspend fun updateNote(note: Notes){
        noteDao.updateNote(note)
    }

    suspend fun deleteNote(note:Notes){
        noteDao.deleteNote(note)
    }
}