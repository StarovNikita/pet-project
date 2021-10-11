package com.example.pet_project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

open class BaseApp : AppCompatActivity() {

    lateinit var appComponent: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent = DaggerAppComponent.create()
    }
}