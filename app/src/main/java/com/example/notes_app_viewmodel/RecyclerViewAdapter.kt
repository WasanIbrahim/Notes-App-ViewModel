package com.example.notes_app_viewmodel

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.notes_app_viewmodel.databinding.ItemRowBinding

class RecyclerViewAdapter(private val activity: MainActivity):RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {
    var notesList = emptyList<Notes>()
    class ItemViewHolder(val binding: ItemRowBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent ,false)
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val notes = notesList[position]

        holder.binding.apply {
            val note = "${notes.note}"
            noteText.text = note

            deleteButton.setOnClickListener {
                activity.noteViewModel.deleteNote(notes.pk)
            }

            editButton.setOnClickListener {
                val intent = Intent(holder.itemView.context, UpdateActivity::class.java)
                intent.putExtra("pk", notes.pk)
                intent.putExtra("note", notes.note)
                holder.itemView.context.startActivity(intent)
            }
        }
    }

    override fun getItemCount(): Int {
       return notesList.size
    }
    fun updateData(notes: List<Notes>){
        this.notesList = notes
        notifyDataSetChanged()
    }
}