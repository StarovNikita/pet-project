package com.example.pet_project.ui.main

import com.arellomobile.mvp.MvpView
import com.example.pet_project.model.hero.HeroResponse

interface MainViewInterface : MvpView {

    fun showHeroList(heroResponse: HeroResponse)
}