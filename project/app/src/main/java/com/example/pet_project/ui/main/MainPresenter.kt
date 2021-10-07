package com.example.pet_project.ui.main

import com.example.pet_project.model.MovieResponse
import com.example.pet_project.network.Service
import javax.inject.Inject

class MainPresenter @Inject constructor(private val service: Service, val view: MainViewInterface) {

    fun getMovieList() {
        service.getMovieList(object : Service.GetMovieListCallback {
            override fun onSuccess(movieListResponse: MovieResponse?) {
                movieListResponse?.let { view.showMovieList(it) }
            }
        })
    }
}