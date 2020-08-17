package com.diegofajardo.stackexchangeapp.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BadgeCounts(
    val bronze: Int,
    val silver: Int,
    val gold: Int
) : Parcelable