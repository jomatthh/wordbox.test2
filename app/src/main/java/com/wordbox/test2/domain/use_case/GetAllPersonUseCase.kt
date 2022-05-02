package com.wordbox.test2.domain.use_case

import com.wordbox.test2.domain.repository.PersonRepository

class GetAllPersonUseCase(
    private val repository: PersonRepository
) {
    suspend fun execute() =  repository.getAll()
}