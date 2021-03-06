package com.example.home_details_future.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.home_details_future.R

class EventLoadStateAdapter(private val retry:() -> Unit):LoadStateAdapter<EventLoadStateAdapter.EventLoadStateViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): EventLoadStateViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.event_load_state, parent, false)
        return EventLoadStateViewHolder(v, retry)
    }

    override fun onBindViewHolder(holder: EventLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    class EventLoadStateViewHolder(view:View, retry: () -> Unit):RecyclerView.ViewHolder(view){
        private val errorMsg: TextView = view.findViewById(R.id.event_load_state_error_msg)
        private val retryBtn: Button = view.findViewById(R.id.event_load_state_retry_button)
        private val progressBar: ProgressBar = view.findViewById(R.id.event_load_state_progress_bar)

        init {
            retryBtn.setOnClickListener { retry.invoke() }
        }

        fun bind(loadState: LoadState){
            if (loadState is LoadState.Error) {
                errorMsg.text = loadState.error.localizedMessage
            }
            progressBar.isVisible = loadState is LoadState.Loading
            retryBtn.isVisible = loadState !is LoadState.Loading
            errorMsg.isVisible = loadState !is LoadState.Loading
        }
    }
}