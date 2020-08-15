package com.diegofajardo.stackexchangeapp.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    val username: String,
    val reputation: String
) : Parcelable