package com.example.pet_project.ui.main

import com.example.pet_project.model.MovieResponse
import com.example.pet_project.network.Service

class MainPresenter(private val service: Service, val view: MainViewInterface) {

    fun getMovieList() {
        service.getMovieList(object : Service.GetMovieListCallback {
            override fun onSuccess(movieListResponse: MovieResponse?) {
                movieListResponse?.let { view.getMovieListSuccess(it) }
            }
        })
    }
}