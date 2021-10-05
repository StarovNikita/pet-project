package com.example.pet_project.network

import android.util.Log
import com.example.pet_project.Constants
import com.example.pet_project.model.MovieResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class Service @Inject constructor(private val networkService: NetworkService) {

    fun getMovieList(callback: GetMovieListCallback) : Disposable =
        networkService.getMovies(Constants.API_KEY)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                callback.onSuccess(it)
            },
                { throwable -> Log.e("showErrorMessage", "showErrorMessage $throwable") })

    interface GetMovieListCallback {
        fun onSuccess(movieListResponse: MovieResponse?)
    }
}