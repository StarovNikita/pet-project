package com.example.pet_project.ui.main

import com.example.pet_project.model.HeroResponse

interface MainViewInterface {

    fun showMovieList(heroResponse: HeroResponse)
}