package com.example.pet_project.network

import com.example.pet_project.model.hero.HeroResponse
import io.reactivex.rxjava3.core.Observable

interface RemoteRepository {

    fun getHeroList() : Observable<HeroResponse>

    fun getHeroListBasedOnName(query : String): Observable<HeroResponse>
}