package com.example.home_details_future.comicsDetails

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.home_details_future.R
import com.google.android.material.transition.MaterialContainerTransform
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_comics_details.*


class ComicsDetails : Fragment(R.layout.fragment_comics_details) {

    val args:ComicsDetailsArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postponeEnterTransition()
        sharedElementEnterTransition = MaterialContainerTransform()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val comics = args.comicsItem

        comics_poster.transitionName = getString(R.string.transition_comics) + comics.id

        loadBackgroundImg("${comics.thumbnail.path}.${comics.thumbnail.extension}")
        loadPosterImg("${comics.thumbnail.path}.${comics.thumbnail.extension}")
        setToolbarTitle(comics.title)
        setPageCount(comics.pageCount)
        setUpdateDate(comics.modified)
        setDescription(comics.description)

        startPostponedEnterTransition()
    }

    private fun loadPosterImg(src: String) {
        Picasso.get()
            .load(src)
            .into(comics_poster)
    }

    private fun setToolbarTitle(title:String){
        comics_details_toolbar.title = title
    }

    private fun loadBackgroundImg(src:String?){
        Picasso.get()
            .load(src)
            .into(comics_background_img)
    }

    private fun setPageCount(count:Int){
        comics_pages_count.text = "$count ${getString(R.string.pages)}"
    }

    private fun setUpdateDate(date:String){
        comics_last_update_time.text = date.subSequence(0, 10)
    }

    private fun setDescription(text:String?){
        comics_description.text = text ?: getString(R.string.no_description)
    }
}