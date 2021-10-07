package com.example.pet_project.model

import com.google.gson.annotations.SerializedName

data class HeroResponse(
    @SerializedName("results")
    val results: List<Result>
)