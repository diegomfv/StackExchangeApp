package com.diegofajardo.stackexchangeapp.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val userId: Int,
    val username: String,
    val reputation: String,

    val badgeCounts: BadgeCounts,
    val location: String,
    val age: String?,
    val creationDate: Long,
    val profileImageUrl: String
) : Parcelable