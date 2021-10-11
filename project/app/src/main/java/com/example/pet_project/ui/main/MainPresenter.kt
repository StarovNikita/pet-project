package com.example.pet_project.ui.main

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.widget.SearchView
import androidx.navigation.fragment.NavHostFragment
import com.example.pet_project.R
import com.example.pet_project.model.hero.Result
import com.example.pet_project.network.Interactor
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject

class MainPresenter @Inject constructor(private val interactor: Interactor,private val view: MainViewInterface) : CardClicked {

    fun getHeroList() {
        interactor.getHeroList()
            .subscribe({
           view.showHeroList(it)
        },
            { throwable -> Log.e("showErrorMessage", "showErrorMessage $throwable") })
    }

    fun getHeroListBasedOnName(searchView: SearchView) {
        interactor.getHeroListBasedOnName(fromView(searchView))
            .subscribe({
                view.showHeroList(it)
            },
                { throwable -> Log.e("showErrorMessage", "showErrorMessage $throwable") })
    }

    private fun fromView(searchView: SearchView): Observable<String> {
        val subject: PublishSubject<String> = PublishSubject.create()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(text: String?): Boolean {
                subject.onNext(text)
                return true
            }

            override fun onQueryTextChange(text: String?): Boolean {
                subject.onNext(text)
                return true
            }
        })
        return subject
    }

    override fun heroCardClicked(selectedHero: Result,activity: MainActivity) {
        val heroFragment = HeroFragment()
        val bundle = Bundle()
        val navHostFragment =
            activity.supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
        bundle.putParcelable("selectedHero",selectedHero)
        heroFragment.arguments = bundle
        navController.navigate(R.id.action_MainListFragment_to_HeroFragment)
    }

    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long){}
}