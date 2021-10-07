package com.example.pet_project.ui.main

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pet_project.BaseApp
import com.example.pet_project.R
import com.example.pet_project.adapters.MovieAdapter
import com.example.pet_project.databinding.ActivityMainBinding
import com.example.pet_project.model.MovieResponse
import com.example.pet_project.network.Service
import javax.inject.Inject


class MainActivity : BaseApp(), MainViewInterface {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter
    private lateinit var mainPresenter: MainPresenter
    @Inject
    lateinit var service: Service

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appComponent.inject(this)
        initAllFields()
    }

    private fun initAllFields() {
        mainPresenter = MainPresenter(service,this)
        mainPresenter.getMovieList()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.moviesList.setHasFixedSize(true)
        binding.moviesList.layoutManager = LinearLayoutManager(this)
    }

    override fun showMovieList(movieResponse: MovieResponse) {
        adapter = MovieAdapter(movieResponse.results,applicationContext)
        binding.moviesList.adapter = adapter
    }

}