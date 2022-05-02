package com.wordbox.test2.presentation.person.mapper

import com.wordbox.test2.domain.model.Person
import com.wordbox.test2.presentation.person.model.PersonModel

fun Person.toPersonModel(): PersonModel {
    return PersonModel(
        name = "${name.first} ${name.last}",
        pictureUrl = picture.large,
        email = email,
        gender = gender,
        age = personAge.age,
        city = location.city
    )
}

fun List<Person>.toModel(): List<PersonModel> {
    return map { it.toPersonModel() }
}