package com.example.pet_project.model.hero

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Result(
    @SerializedName("appearance")
    val appearance: HeroAppearance,
    @SerializedName("image")
    val image: HeroImage,
    @SerializedName("name")
    var name: String,
    @SerializedName("powerstats")
    val powerstats: HeroPowerstats,
) : Parcelable