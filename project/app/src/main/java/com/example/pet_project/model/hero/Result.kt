package com.example.pet_project.model.hero

import com.example.pet_project.model.hero.HeroAppearance
import com.example.pet_project.model.hero.HeroImage
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("appearance")
    val appearance: HeroAppearance,
    @SerializedName("image")
    val image: HeroImage,
    @SerializedName("name")
    val name: String
)