package com.example.pet_project.model.hero

import com.google.gson.annotations.SerializedName

data class HeroImage(
    @SerializedName("url")
    val url: String
)