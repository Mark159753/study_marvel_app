package com.example.home_details_future.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Event
import com.example.home_details_future.R
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class EventAdapter(private val listener:EventSelectListener): PagingDataAdapter<Event, RecyclerView.ViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.event_item, parent, false)
        return EventViewHolder(v, listener)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is EventViewHolder -> holder.bind(getItem(position))
        }
    }

    class EventViewHolder(private val view: View, private val listener: EventSelectListener):RecyclerView.ViewHolder(view){
        private val img:ShapeableImageView = view.findViewById(R.id.event_img)
        private val title:TextView = view.findViewById(R.id.event_title)
        private val description:TextView = view.findViewById(R.id.event_description)

        fun bind(item:Event?){
            item?.let {
                Picasso.get()
                    .load(item.thumbnail)
                    .into(img)
                title.text = item.title
                description.text = item.description

                view.setOnClickListener { v -> listener.onEventSelected(v, it) }
            }
        }
    }

    interface EventSelectListener{
        fun onEventSelected(view: View, item: Event)
    }

    private companion object COMPARATOR: DiffUtil.ItemCallback<Event>(){
        override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean {
            return oldItem == newItem
        }
    }
}