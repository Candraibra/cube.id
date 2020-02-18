package com.candraibra.barvolume.practice

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Person(
    val name: String?,
    val age: Int?,
    val email: String?

) : Parcelable

