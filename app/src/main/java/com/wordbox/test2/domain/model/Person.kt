package com.wordbox.test2.domain.model

data class Person(
    val gender: String,
    val name: PersonName,
    val picture: PersonPicture,
    val location: Location,
    val email: String,
    val personAge: PersonAge
)

data class PersonAge(
    val age:Int
)

data class Location(
    val city: String
)

data class PersonName(
    val title: String,
    val first: String,
    val last: String?
)

data class PersonPicture(
    val large: String,
    val medium: String,
    val thumbnail: String
)
