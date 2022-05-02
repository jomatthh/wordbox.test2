package com.wordbox.test2.data.remote.api_impl

import com.wordbox.test2.data.remote.HttpRoutes
import com.wordbox.test2.data.remote.api.PersonService
import com.wordbox.test2.data.remote.model.PersonResponse
import io.ktor.client.*
import io.ktor.client.request.*

class PersonServiceImpl(
    private val client: HttpClient
) : PersonService {

    override suspend fun getAll(): PersonResponse {
        return try {
            client.get {
                url(HttpRoutes.PERSON)

            }
        } catch (e: Exception) {
            println(e.message)
            PersonResponse(emptyList())
        }
    }
}
