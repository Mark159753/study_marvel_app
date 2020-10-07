package com.example.home_details_future.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.domain.model.Comics
import com.example.domain.model.Event
import com.example.home_details_future.R
import com.example.home_details_future.di.HomeDetailsInjector
import com.example.home_details_future.home.adapter.*
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialContainerTransform
import com.google.android.material.transition.MaterialElevationScale
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragment : Fragment(R.layout.home_fragment),
    ComicsAdapter.ComicsItemClickListener, EventAdapter.EventSelectListener {

    private val comicAdapter = ComicsAdapter(this)
    private val eventAdapter = EventAdapter(this)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel: HomeViewModel by viewModels{ viewModelFactory }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        injectMe()

        initComicAdapter()
        initEventAdapter()
        observeComics()
        observeEvents()
    }


    private fun initEventAdapter(){
        event_list.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = eventAdapter.withLoadStateFooter(EventLoadStateAdapter{ eventAdapter.retry() })
            addItemDecoration(MarginItemDecorator(resources.getDimensionPixelSize(R.dimen.list_item_offset), resources.getDimensionPixelSize(R.dimen.horizontal_margin)))
            setHasFixedSize(true)
        }
    }

    private fun observeEvents(){
        lifecycleScope.launch {
            viewModel.events.collect {
                eventAdapter.submitData(it)
            }
        }
    }

    private fun observeComics(){
        lifecycleScope.launch {
            viewModel.comics.collect {
                comicAdapter.submitData(it)
            }
        }
    }

    private fun initComicAdapter(){
        comics_horizontal_list.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = comicAdapter.withLoadStateFooter(ComicLoadStateAdapter{ comicAdapter.retry() })
            addItemDecoration(MarginItemDecorator(0, resources.getDimensionPixelSize(R.dimen.horizontal_margin), true))
            setHasFixedSize(true)
        }
    }

    private fun injectMe(){
        (activity?.application as HomeDetailsInjector)
            .getFragmentComponent()
            .create()
            .inject(this)
    }


    override fun onComicsClick(view: View, item: Comics) {
        val img = view.findViewById<ImageView>(R.id.comics_poster)
        val action = HomeFragmentDirections.homeToComicsDetails(item)
        val extras = FragmentNavigatorExtras(img to getString(R.string.transition_comics) + item.id)
        view.findNavController().navigate(action, extras)
    }

    override fun onEventSelected(view: View, item: Event) {
        val action = HomeFragmentDirections.homeToEventDetails(item)
        view.findNavController().navigate(action)
    }

    private val Int.dp:Int
        get() {
            val d = resources.displayMetrics.density
            return (this * d).toInt()
        }
}

