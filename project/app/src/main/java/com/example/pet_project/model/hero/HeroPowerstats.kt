package com.example.pet_project.model.hero

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class HeroPowerstats(
    @SerializedName("combat")
    var combat: String,
    @SerializedName("durability")
    var durability: String,
    @SerializedName("intelligence")
    var intelligence: String,
    @SerializedName("power")
    var power: String,
    @SerializedName("speed")
    var speed: String,
    @SerializedName("strength")
    var strength: String
) : Parcelable