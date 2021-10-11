package com.example.pet_project.ui.main

import android.widget.AdapterView
import com.example.pet_project.model.hero.Result

interface CardClicked : AdapterView.OnItemClickListener {

    fun heroCardClicked(selectedHero : Result,activity: MainActivity)
}