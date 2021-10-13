package com.example.pet_project

import android.app.Application
import com.example.pet_project.di.component.ApplicationComponent
import com.example.pet_project.di.component.DaggerApplicationComponent
import com.example.pet_project.di.module.ApplicationModule
import com.example.pet_project.di.module.GlobalModule
import com.example.pet_project.di.module.NetworkModule

class BaseApp : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        setup()
    }

    private fun setup() {
        component = DaggerApplicationComponent.builder().networkModule(NetworkModule()).globalModule(
            GlobalModule()).applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

    companion object{
        @JvmStatic
        lateinit var  instance: BaseApp private set
    }
}