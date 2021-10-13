package com.example.pet_project.ui.main

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.pet_project.model.hero.HeroResponse

@StateStrategyType(OneExecutionStateStrategy::class)
interface MainViewInterface : MvpView {

    fun showHeroList(heroResponse: HeroResponse)
    fun openFragment()
}