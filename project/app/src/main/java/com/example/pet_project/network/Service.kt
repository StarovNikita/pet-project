package com.example.pet_project.network


import android.util.Log
import com.example.pet_project.Constants
import com.example.pet_project.model.HeroResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class Service @Inject constructor(private val networkService: NetworkService) {

    fun getHeroList(callback: GetMovieListCallback) {
        networkService.getResult(Constants.API_KEY,)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                callback.onSuccess(it)
            },
                { throwable -> Log.e("showErrorMessage", "showErrorMessage $throwable") })
    }

    fun getHeroListBasedOnName(callback: GetMovieListCallback, subject: Observable<String>) {
        subject
            .filter { it.isNotEmpty() }
            .debounce(300, TimeUnit.MILLISECONDS)
            .distinctUntilChanged()
            .switchMap { networkService.getResultBasedOnName(Constants.API_KEY, it) }
            .filter { it.results.isNotEmpty() }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                callback.onSuccess(it)
            },
                { throwable -> Log.e("showErrorMessage", "showErrorMessage $throwable") })
    }

    interface GetMovieListCallback {
        fun onSuccess(heroListResponse: HeroResponse?)
    }
}