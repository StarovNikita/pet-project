package com.example.pet_project.model.hero

import com.google.gson.annotations.SerializedName

data class HeroResponse(
    @SerializedName("results")
    val results: List<Result>
)