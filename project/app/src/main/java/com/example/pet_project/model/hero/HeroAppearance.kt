package com.example.pet_project.model.hero

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class HeroAppearance(
    @SerializedName("gender")
    var gender: String,
    @SerializedName("race")
    var race: String
) : Parcelable