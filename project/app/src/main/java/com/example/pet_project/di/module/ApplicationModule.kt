package com.example.pet_project.di.module

import android.app.Application
import com.example.pet_project.BaseApp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private var baseApp: BaseApp) {

    @Provides
    @Singleton
    fun provideApplication() : Application = baseApp
}