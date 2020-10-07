package com.example.modulartest.ui.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Character
import com.example.modulartest.R
import com.squareup.picasso.Picasso

class MarvelCharacterAdapter: PagingDataAdapter<Character, RecyclerView.ViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return CharacterViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CharacterViewHolder -> holder.bind(getItem(position))
        }
    }

    inner class CharacterViewHolder(view: View):RecyclerView.ViewHolder(view){
        private val img:ImageView = view.findViewById(R.id.character_poster)
        private val name:TextView = view.findViewById(R.id.character_name)

        fun bind(item:Character?){
            item?.let {
                Picasso.get()
                    .load(item.thumbnail.path + "." + item.thumbnail.extension)
                    .into(img)
                name.text = item.name
            }
        }
    }

    private companion object COMPARATOR : DiffUtil.ItemCallback<Character>(){
        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
            return oldItem == newItem
        }
    }
}