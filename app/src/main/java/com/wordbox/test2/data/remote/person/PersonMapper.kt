package com.wordbox.test2.data.remote.person

import com.wordbox.test2.data.remote.model.LocationRemote
import com.wordbox.test2.data.remote.model.PersonAgeRemote
import com.wordbox.test2.data.remote.model.PersonNameRemote
import com.wordbox.test2.data.remote.model.PersonPictureRemote
import com.wordbox.test2.data.remote.model.PersonRemote
import com.wordbox.test2.domain.model.Location
import com.wordbox.test2.domain.model.Person
import com.wordbox.test2.domain.model.PersonAge
import com.wordbox.test2.domain.model.PersonName
import com.wordbox.test2.domain.model.PersonPicture

fun List<PersonRemote>.toDomain(): List<Person> {
    return map {
        it.toPerson()
    }
}

fun PersonRemote.toPerson(): Person {
    return Person(
        gender = gender.orEmpty(),
        name = name.toPersonName(),
        picture = picture.toPersonPicture(),
        location = location.toLocation(),
        personAge = dob.toPersonAge(),
        email = email.orEmpty()
    )
}

fun LocationRemote.toLocation(): Location {
    return Location(
        city = city.orEmpty()
    )
}

fun PersonAgeRemote.toPersonAge(): PersonAge {
    return PersonAge(
        age = age ?: 0
    )
}

fun PersonNameRemote.toPersonName(): PersonName {
    return PersonName(
        title = title.orEmpty(),
        first = first.orEmpty(),
        last = last.orEmpty()
    )
}

fun PersonPictureRemote.toPersonPicture(): PersonPicture {
    return PersonPicture(
        large = large.orEmpty(),
        medium = medium.orEmpty(),
        thumbnail = thumbnail.orEmpty()
    )
}