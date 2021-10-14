package com.example.pet_project.model.hero

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class HeroAppearance(
    @SerializedName("gender")
    var gender: String,
    @SerializedName("race")
    var race: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString()
    )

    override fun describeContents(): Int = 0

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(gender)
        parcel.writeString(race)
    }

    companion object CREATOR : Parcelable.Creator<HeroAppearance> {
        override fun createFromParcel(parcel: Parcel): HeroAppearance {
            return HeroAppearance(parcel)
        }

        override fun newArray(size: Int): Array<HeroAppearance?> {
            return arrayOfNulls(size)
        }
    }
}