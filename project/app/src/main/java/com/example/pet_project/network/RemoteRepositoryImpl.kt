package com.example.pet_project.network

import com.example.pet_project.Constants
import com.example.pet_project.model.hero.HeroResponse
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(private val networkService: NetworkService) :
    RemoteRepository {

    override fun getHeroList() : Observable<HeroResponse> =
        networkService.getResult(Constants.API_KEY)

    override fun getHeroListBasedOnName(query: String) : Observable<HeroResponse> =
        networkService.getResultBasedOnName(Constants.API_KEY, query)
}