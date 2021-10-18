package com.example.pet_project.ui.mainList

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.pet_project.model.hero.HeroResponse
import com.example.pet_project.model.hero.Result

@StateStrategyType(OneExecutionStateStrategy::class)
interface MainListViewInterface : MvpView {

    fun showHeroList(heroResponse: HeroResponse)
    fun openFragment(selectedHero: Result)
}