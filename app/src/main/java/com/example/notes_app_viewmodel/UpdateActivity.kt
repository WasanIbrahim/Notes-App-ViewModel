package com.example.notes_app_viewmodel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class UpdateActivity : AppCompatActivity() {

    lateinit var noteViewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        noteViewModel = ViewModelProvider(this).get(MyViewModel::class.java)

        val pk = intent.getIntExtra("pk", 0)
        val note = intent.getStringExtra("note")

        val updateButton = findViewById<Button>(R.id.btUpdate)
        val updateText = findViewById<EditText>(R.id.tvUpdate)
        updateText.hint = note


        updateButton.setOnClickListener {
                if (note != null) {
                    val newNote = updateText.text.toString()
                    noteViewModel.updateNote(Notes(pk,newNote))
                }

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
    }
}