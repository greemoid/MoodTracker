package com.greemoid.moodtracker.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greemoid.moodtracker.databinding.NoteItemLayoutBinding
import com.greemoid.moodtracker.models.Note

class DiaryAdapter: RecyclerView.Adapter<DiaryAdapter.DiaryViewHolder>() {

    private var notesList: List<Note> = emptyList()

    class DiaryViewHolder(
        val binding: NoteItemLayoutBinding
        ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiaryViewHolder {
        val binding = NoteItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DiaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DiaryViewHolder, position: Int) {
        val note = notesList[position]
        holder.binding.textViewTitle.text = note.title
        holder.binding.textViewDescription.text = note.description

        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it(note) }
        }
    }

    override fun getItemCount(): Int = notesList.size

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<Note>) {
        notesList = list
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(listener: (Note) -> Unit) {
        onItemClickListener = listener
    }

    private var onItemClickListener: ((Note) -> Unit)? = null
}