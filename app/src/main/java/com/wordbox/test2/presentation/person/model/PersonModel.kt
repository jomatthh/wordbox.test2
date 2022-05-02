package com.wordbox.test2.presentation.person.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PersonModel(
    val name: String,
    val pictureUrl: String,
    val email: String,
    val gender: String,
    val city: String,
    val age: Int
): Parcelable
