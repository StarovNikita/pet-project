package com.example.pet_project.model.hero

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

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
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(combat)
        parcel.writeString(durability)
        parcel.writeString(intelligence)
        parcel.writeString(power)
        parcel.writeString(speed)
        parcel.writeString(strength)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<HeroPowerstats> {
        override fun createFromParcel(parcel: Parcel): HeroPowerstats {
            return HeroPowerstats(parcel)
        }

        override fun newArray(size: Int): Array<HeroPowerstats?> {
            return arrayOfNulls(size)
        }
    }
}