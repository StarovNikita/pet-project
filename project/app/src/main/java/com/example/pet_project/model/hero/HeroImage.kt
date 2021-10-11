package com.example.pet_project.model.hero

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class HeroImage(
    @SerializedName("url")
    var url: String
) : Parcelable