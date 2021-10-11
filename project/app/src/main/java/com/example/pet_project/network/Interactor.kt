package com.example.pet_project.network

import com.example.pet_project.model.hero.HeroResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class Interactor @Inject constructor(private val remoteRepositoryImpl: RemoteRepositoryImpl) {

    fun getHeroList(): Observable<HeroResponse> =
        remoteRepositoryImpl.getHeroList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun getHeroListBasedOnName(subject: Observable<String>): Observable<HeroResponse> =
        subject
            .filter { it.isNotEmpty() }
            .debounce(300, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
            .switchMap { remoteRepositoryImpl.getHeroListBasedOnName(it) }
            .filter { it.results.isNotEmpty() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}