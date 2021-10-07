package com.example.pet_project.model.hero

import com.google.gson.annotations.SerializedName

data class HeroAppearance(
    @SerializedName("gender")
    val gender: String,
    @SerializedName("race")
    val race: String
)