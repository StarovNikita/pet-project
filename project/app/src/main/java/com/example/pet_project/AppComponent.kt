package com.example.pet_project

import com.example.pet_project.network.NetworkModule
import com.example.pet_project.ui.main.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}