package com.example.pet_project.ui

import com.example.pet_project.model.MovieResponse

interface MainViewInterface {

    fun displayMovies(movieResponse: MovieResponse)
    fun displayError(error: String)
}