package com.example.modulartest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modulartest.MarvelApp
import com.example.modulartest.R
import com.example.modulartest.ui.adapter.MarvelCharacterAdapter
import com.example.modulartest.ui.adapter.MarvelLoadStateAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

//    @Inject
//    lateinit var viewModelFactory: ViewModelProvider.Factory
//    private val viewModel:MainViewModel by viewModels{ viewModelFactory }
//
//    private val adapter = MarvelCharacterAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        injectMe()
//        initRecyclerView()
//        observeCharacters()
    }

//    private fun observeCharacters(){
//        lifecycleScope.launch {
//            viewModel.characters.collect {
//                adapter.submitData(it)
//            }
//        }
//    }
//
//
//    private fun initRecyclerView(){
//        character_rv.apply {
//            layoutManager = LinearLayoutManager(context)
//            adapter = this@MainActivity.adapter.withLoadStateFooter(MarvelLoadStateAdapter{ this@MainActivity.adapter.retry() })
//            setHasFixedSize(true)
//        }
//    }
//
//    private fun injectMe(){
//        (application as MarvelApp)
//            .appComponent
//            .getDataSubComponent()
//            .create()
//            .inject(this)
//    }


}