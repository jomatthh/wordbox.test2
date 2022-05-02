package com.wordbox.test2.data.remote.api

import com.wordbox.test2.data.remote.model.PersonResponse

interface PersonService {
    suspend fun getAll(): PersonResponse
}