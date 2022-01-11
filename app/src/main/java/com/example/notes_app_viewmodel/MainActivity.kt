package com.example.notes_app_viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var submitButton: Button
    lateinit var noteText: EditText
    lateinit var rvMain: RecyclerView

    lateinit var rvAdapter: RecyclerViewAdapter

    lateinit var noteViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submitButton = findViewById(R.id.submitButton)
        noteText = findViewById(R.id.noteEditText)
        rvMain = findViewById(R.id.rvMain)

        rvAdapter = RecyclerViewAdapter(this)
        rvMain.adapter = rvAdapter
        rvMain.layoutManager = LinearLayoutManager(this)


        //initializing viewModel
        noteViewModel = ViewModelProvider(this).get(MyViewModel::class.java)


        //getting and updating notes
        noteViewModel.getNotes().observe(this, {
                notes -> rvAdapter.updateData(notes)
        })

        submitButton.setOnClickListener {
            if (noteText.text.isNotEmpty()){
                noteViewModel.addNote(noteText.text.toString())
                noteText.text = null
            }
        }
    }
}