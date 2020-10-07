package com.example.home_details_future.eventDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.home_details_future.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_event_details.*


class EventDetailsFragment : Fragment(R.layout.fragment_event_details) {

    val args:EventDetailsFragmentArgs  by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val event = args.eventItem

        setEventPosterImg(event.thumbnail)
        setEventTitle(event.title)
        setEventDescription(event.description)
    }

    private fun setEventPosterImg(src:String){
        Picasso.get()
            .load(src)
            .into(event_poster)
    }

    private fun setEventTitle(title:String){
        event_details_title.text = title
    }

    private fun setEventDescription(description:String){
        event_details_description.text = description
    }

}