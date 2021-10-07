package com.example.pet_project.ui.main

import com.example.pet_project.model.hero.HeroResponse

interface MainViewInterface {

    fun showHeroList(heroResponse: HeroResponse)
}