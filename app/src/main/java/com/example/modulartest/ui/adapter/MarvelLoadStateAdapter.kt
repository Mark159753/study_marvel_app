package com.example.modulartest.ui.adapter

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
import com.example.modulartest.R

class MarvelLoadStateAdapter(private val retry: () -> Unit) : LoadStateAdapter<MarvelLoadStateAdapter.MarvelLoadStateViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): MarvelLoadStateViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.repos_load_state_footer_view_item, parent, false)
        return MarvelLoadStateViewHolder(retry, v)
    }

    override fun onBindViewHolder(holder: MarvelLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    class MarvelLoadStateViewHolder(retry: () -> Unit, view:View):RecyclerView.ViewHolder(view){
        private val retryBtn:Button = view.findViewById(R.id.retry_button)
        private val errorMsg:TextView = view.findViewById(R.id.error_msg)
        private val progressBar:ProgressBar = view.findViewById(R.id.progress_bar)

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