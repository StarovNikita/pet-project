package com.example.pet_project.model.user

import com.example.pet_project.model.hero.Result

data class User(
    val login : String,
    val password : String,
    val chosenHeroList : List<Result>
)
