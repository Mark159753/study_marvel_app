package com.example.home_details_future.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Comics
import com.example.home_details_future.R
import com.squareup.picasso.Picasso

class ComicsAdapter(private val listener:ComicsItemClickListener): PagingDataAdapter<Comics, RecyclerView.ViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.comics_item, parent, false)
        return ComicsViewHolder(v, listener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ComicsViewHolder -> holder.bind(getItem(position))
        }
    }

    class ComicsViewHolder(private val view:View, private val listener:ComicsItemClickListener):RecyclerView.ViewHolder(view){
        private val img:ImageView = view.findViewById(R.id.comics_poster)
        private val title:TextView = view.findViewById(R.id.comics_name)
        private val author:TextView = view.findViewById(R.id.comics_author)


        fun bind(item:Comics?){
            item?.let {comics ->
                Picasso.get()
                    .load(item.thumbnail.path + "." + item.thumbnail.extension)
                    .into(img)
                title.text = item.title
                author.text = comics.creators ?: author.context.getString(R.string.unknown)
                view.setOnClickListener { listener.onComicsClick(it, item) }
                img.transitionName = img.context.getString(R.string.transition_comics) + comics.id
            }
        }
    }

    interface ComicsItemClickListener{
        fun onComicsClick(view: View, item: Comics)
    }

    private companion object COMPARATOR: DiffUtil.ItemCallback<Comics>(){
        override fun areItemsTheSame(oldItem: Comics, newItem: Comics): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Comics, newItem: Comics): Boolean {
            return oldItem == newItem
        }
    }
}