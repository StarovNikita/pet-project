package com.example.pet_project.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("title")
    @Expose
    val title: String,
    @SerializedName("poster_path")
    @Expose
    val posterPath: String,
    @SerializedName("overview")
    @Expose
    val overview: String,
    @SerializedName("release_date")
    @Expose
    val releaseDate: String
)