package com.example.pet_project.di.component

import com.example.pet_project.di.module.NetworkModule
import com.example.pet_project.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
}