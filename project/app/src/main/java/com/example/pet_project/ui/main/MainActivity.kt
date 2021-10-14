package com.example.pet_project.ui.main

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.example.pet_project.R

class MainActivity : MvpAppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}