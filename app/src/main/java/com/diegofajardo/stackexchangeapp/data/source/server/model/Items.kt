package com.diegofajardo.stackexchangeapp.data.source.server.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Items(
    @SerializedName("items") val users: List<ServerUser>
) : Parcelable