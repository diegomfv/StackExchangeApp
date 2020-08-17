package com.diegofajardo.stackexchangeapp.data.source.server.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ServerUser(
    @SerializedName("user_id") val userId: Int,
    @SerializedName("display_name") val username: String,
    @SerializedName("reputation") val reputation: String,

    @SerializedName("badge_counts") val serverBadgeCounts: ServerBadgeCounts,
    @SerializedName("location") val location: String?,
    @SerializedName("age") val age: String?,
    @SerializedName("creation_date") val creationDate: Long,
    @SerializedName("profile_image") val profileImageUrl: String
) : Parcelable