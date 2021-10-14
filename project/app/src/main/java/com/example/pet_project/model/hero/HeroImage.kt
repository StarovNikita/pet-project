package com.example.pet_project.model.hero

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class HeroImage(
    @SerializedName("url")
    var url: String
) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString().toString())

    override fun describeContents(): Int = 0

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(url)
    }

    companion object CREATOR : Parcelable.Creator<HeroImage> {
        override fun createFromParcel(parcel: Parcel): HeroImage {
            return HeroImage(parcel)
        }

        override fun newArray(size: Int): Array<HeroImage?> {
            return arrayOfNulls(size)
        }
    }
}