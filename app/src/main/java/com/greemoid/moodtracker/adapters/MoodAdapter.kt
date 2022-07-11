package com.greemoid.moodtracker.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greemoid.moodtracker.R
import com.greemoid.moodtracker.databinding.MoodItemLayoutBinding
import com.greemoid.moodtracker.models.Mood
import com.greemoid.moodtracker.utils.*

class MoodAdapter : RecyclerView.Adapter<MoodAdapter.MoodViewHolder>() {

    private var moodList: List<Mood> = emptyList()

    class MoodViewHolder(val binding: MoodItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoodViewHolder {
        val binding = MoodItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MoodViewHolder, position: Int) {
        val mood = moodList[position]
        holder.binding.apply {
            dateMood.text = mood.date
            tvMood.text = mood.textOfMood

            ivMood.setImageResource(when(mood.mood) {
                HAPPY -> R.drawable.happy
                LOVELY -> R.drawable.lovely
                NORMAL -> R.drawable.normal
                SAD -> R.drawable.sad
                VERY_SAD -> R.drawable.very_sad

                else -> R.drawable.happy
            })
        }
    }

    override fun getItemCount(): Int = moodList.size


    fun setList(list: List<Mood>) {
        moodList = list
        notifyDataSetChanged()
    }

}