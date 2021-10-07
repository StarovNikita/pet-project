package com.example.pet_project.ui.main

import android.os.Bundle
import com.example.pet_project.BaseApp
import com.example.pet_project.R


class MainActivity : BaseApp() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appComponent.inject(this)

    }
}