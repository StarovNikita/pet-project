package com.example.pet_project.di.component

import com.example.pet_project.BaseApp
import com.example.pet_project.di.module.ApplicationModule
import com.example.pet_project.di.module.GlobalModule
import com.example.pet_project.di.module.NetworkModule
import com.example.pet_project.MainActivity
import com.example.pet_project.ui.mainList.MainListPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class, GlobalModule::class])
interface ApplicationComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(baseApp: BaseApp)
    fun inject(listPresenter: MainListPresenter)
}