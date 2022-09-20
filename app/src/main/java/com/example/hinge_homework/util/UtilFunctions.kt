package com.example.hinge_homework.util

import android.view.View

object UtilFunctions {

    fun checkIfNull(value: String?, vararg view: View): String? {
        if (value.isNullOrEmpty()) {
            view.forEach {
                it.visibility = View.GONE
            }
        }
        return value
    }

    fun formatGender(gender: String?): String {
        return when (gender) {
            "f" -> "Female"
            else -> "Male"
        }
    }
}