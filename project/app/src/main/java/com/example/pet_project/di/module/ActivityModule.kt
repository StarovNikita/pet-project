package com.example.pet_project.di.module

import android.app.Activity
import com.example.pet_project.network.Interactor
import com.example.pet_project.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity = activity

    @Provides
    fun providePresenter(interactor: Interactor): MainPresenter = MainPresenter(interactor)
}