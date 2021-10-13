package com.example.pet_project.di.component

import com.example.pet_project.BaseApp
import com.example.pet_project.di.module.ApplicationModule
import dagger.Component

@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application : BaseApp)
}