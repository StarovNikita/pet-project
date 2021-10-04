package com.example.pet_project.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("page")
    @Expose
    val page: Int,
    @SerializedName("total_results")
    @Expose
    val totalResult: Int,
    @SerializedName("total_pages")
    @Expose
    val totalPages: Int,
    @SerializedName("results")
    @Expose
    val results: List<Result>? = null
)