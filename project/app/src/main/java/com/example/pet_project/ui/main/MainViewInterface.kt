package com.example.pet_project.ui.main

import com.example.pet_project.model.MovieResponse

interface MainViewInterface {

    fun getMovieListSuccess(movieResponse : MovieResponse)
}