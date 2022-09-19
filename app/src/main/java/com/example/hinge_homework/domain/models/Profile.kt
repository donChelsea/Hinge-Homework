package com.example.hinge_homework.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Profile(
    val profile: List<String>
) : Parcelable