package com.example.pet_project.network

import com.example.pet_project.model.MovieResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkInterface {

    @GET("discover/movie")
    fun getMovies(@Query("api_key") api_key: String): Observable<MovieResponse>
}