package com.wordbox.test2.domain.repository

import com.wordbox.test2.domain.model.Person
import com.wordbox.test2.vo.OperationResult

interface PersonRepository {
    suspend fun getAll(): OperationResult<List<Person>>
}