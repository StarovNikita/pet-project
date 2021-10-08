package com.example.pet_project.ui.main

import androidx.appcompat.widget.SearchView
import com.example.pet_project.model.hero.HeroResponse
import com.example.pet_project.network.RemoteRepositoryImpl
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject

class MainPresenter @Inject constructor(private val remoteRepositoryImpl: RemoteRepositoryImpl, val view: MainViewInterface) {

    fun getHeroList() {
        remoteRepositoryImpl.getHeroList(object : RemoteRepositoryImpl.GetHeroListCallback {
            override fun onSuccess(heroListResponse: HeroResponse?) {
                heroListResponse?.let { view.showHeroList(it) }
            }
        })
    }

    fun getHeroListBasedOnName(searchView: SearchView) {
        remoteRepositoryImpl.getHeroListBasedOnName(object : RemoteRepositoryImpl.GetHeroListCallback {
            override fun onSuccess(heroListResponse: HeroResponse?) {
                heroListResponse?.let {
                    view.showHeroList(it)
                }
            }
        }, fromView(searchView))
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
}