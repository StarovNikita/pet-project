package com.example.pet_project.model.hero

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Result(
    @SerializedName("name")
    var name: String,
    @SerializedName("appearance")
    val appearance: HeroAppearance?,
    @SerializedName("powerstats")
    val powerstats: HeroPowerstats?,
    @SerializedName("image")
    val image: HeroImage?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readParcelable(HeroAppearance::class.java.classLoader),
        parcel.readParcelable(HeroPowerstats::class.java.classLoader),
        parcel.readParcelable(HeroImage::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeParcelable(appearance, flags)
        parcel.writeParcelable(powerstats, flags)
        parcel.writeParcelable(image, flags)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Result> {
        override fun createFromParcel(parcel: Parcel): Result {
            return Result(parcel)
        }

        override fun newArray(size: Int): Array<Result?> {
            return arrayOfNulls(size)
        }
    }
}