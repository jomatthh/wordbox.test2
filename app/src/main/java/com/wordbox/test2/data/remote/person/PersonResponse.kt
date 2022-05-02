package com.wordbox.test2.data.remote.model

import kotlinx.serialization.Serializable

@Serializable
data class PersonRemote(
    val gender: String?,
    val name: PersonNameRemote,
    val picture: PersonPictureRemote,
    val location: LocationRemote,
    val dob: PersonAgeRemote,
    val email: String?
)

@Serializable
data class LocationRemote(
    val city: String?
)

@Serializable
data class PersonAgeRemote(
    val age: Int?
)


@Serializable
data class PersonNameRemote(
    val title: String?,
    val first: String?,
    val last: String?
)


@Serializable
data class PersonPictureRemote(
    val large: String?,
    val medium: String?,
    val thumbnail: String?
)

@Serializable
data class PersonResponse(
    val results: List<PersonRemote>
)