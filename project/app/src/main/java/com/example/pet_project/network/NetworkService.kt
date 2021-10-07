package com.example.pet_project.network

import com.example.pet_project.model.HeroResponse
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface NetworkService {

    @GET("api/{api_key}/search/a")
    fun getResult(@Path("api_key") api_key: String): Observable<HeroResponse>

    @GET("api/{api_key}/search/{name}")
    fun getResultBasedOnName(
        @Path("api_key") api_key: String,
        @Path("name") name: String
    ): Observable<HeroResponse>
}