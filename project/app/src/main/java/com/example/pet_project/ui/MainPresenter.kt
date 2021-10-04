package com.example.pet_project.ui


import android.util.Log
import com.example.pet_project.model.MovieResponse
import com.example.pet_project.network.NetworkClient
import com.example.pet_project.network.NetworkInterface
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

class MainPresenter(val mvi: MainViewInterface) : MainPresenterInterface {

    private val myTag: String = "MainPresenter"

    override fun getMovies() {
        getObservable().subscribeWith(getObserver())
    }

    fun getObservable(): Observable<MovieResponse> =
        NetworkClient.getRetrofit()
            .create(NetworkInterface::class.java)
            .getMovies("7ec1dc373b9963bd73c4a736cf058279")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun getObserver(): DisposableObserver<MovieResponse> =
        object : DisposableObserver<MovieResponse>() {
            override fun onNext(movieResponse: MovieResponse?) {
                Log.d(myTag, "OnNext ${movieResponse?.totalResult}")
                movieResponse?.let { mvi.displayMovies(it) }
            }

            override fun onError(error: Throwable?) {
                Log.d(myTag, "Error$error")
                error?.printStackTrace()
                mvi.displayError("Error fetching Movie Data")
            }

            override fun onComplete() {
                Log.d(myTag, "Completed")
            }

        }
}