package com.example.pet_project.network

import io.reactivex.rxjava3.core.Observable

interface RemoteRepository {

    fun getHeroList(callback: RemoteRepositoryImpl.GetHeroListCallback)

    fun getHeroListBasedOnName(callback: RemoteRepositoryImpl.GetHeroListCallback, subject: Observable<String>)
}