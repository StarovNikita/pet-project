package com.example.pet_project

import android.app.Application
import com.example.pet_project.di.component.ActivityComponent
import com.example.pet_project.di.component.ApplicationComponent
import com.example.pet_project.di.component.DaggerApplicationComponent
import com.example.pet_project.di.module.ApplicationModule

class BaseApp : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        setup()
    }

    private fun setup() {
        component = DaggerApplicationComponent.builder().build()
        component.inject(this)
    }

    companion object{
        lateinit var  instance: BaseApp private set
    }
}