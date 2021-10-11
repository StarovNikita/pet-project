package com.example.pet_project.ui.main

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.pet_project.model.hero.HeroResponse

@StateStrategyType(value = AddToEndStrategy::class)
interface MainViewInterface : MvpView {

    fun showHeroList(heroResponse: HeroResponse)
}