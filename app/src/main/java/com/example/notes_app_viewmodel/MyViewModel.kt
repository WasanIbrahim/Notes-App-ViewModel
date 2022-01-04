package com.example.notes_app_viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MyViewModel(application: Application): AndroidViewModel(application) {

    private val repository: NoteRepository
    private val notes: LiveData<List<Notes>>

    init {

        val noteDao = noteDB.getDatabase(application).noteDao()
        repository = NoteRepository(noteDao)
        notes = repository.getNote
    }


    fun getNotes():LiveData<List<Notes>>{
        return notes
    }

    fun addNote(note: String){
        CoroutineScope(IO).launch {

            repository.addNote(Notes(0,note))
        }
    }

    fun updateNote(note: Notes){
        CoroutineScope(IO).launch {
            repository.updateNote(note)
        }
    }

    fun deleteNote(pkNote: Int){
        CoroutineScope(IO).launch {
            repository.deleteNote(Notes(pkNote,""))
        }
    }
}