package com.example.pet_project.di.module

import com.example.pet_project.ui.main.MainPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class GlobalModule {

    @Provides
    @Singleton
    fun providePresenter() = MainPresenter()


}