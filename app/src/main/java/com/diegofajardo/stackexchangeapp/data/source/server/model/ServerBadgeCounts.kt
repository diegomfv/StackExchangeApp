package com.diegofajardo.stackexchangeapp.data.source.server.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ServerBadgeCounts(
    @SerializedName("bronze") val bronze: Int,
    @SerializedName("silver") val silver: Int,
    @SerializedName("gold") val gold: Int
) : Parcelable