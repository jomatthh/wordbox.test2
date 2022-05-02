package com.wordbox.test2.data.repository

import com.wordbox.test2.data.remote.person.PersonRemoteDataSource
import com.wordbox.test2.data.remote.person.toDomain
import com.wordbox.test2.domain.model.Person
import com.wordbox.test2.domain.repository.PersonRepository
import com.wordbox.test2.vo.OperationResult

class PersonRepositoryImpl(
    private val dataSource: PersonRemoteDataSource
) : PersonRepository {
    override suspend fun getAll(): OperationResult<List<Person>> {
        return when (val result = dataSource.getAll()) {
            is OperationResult.Success -> {
                val data = result.data.toDomain()
                OperationResult.Success(data)
            }
            is OperationResult.Failure -> {
                result
            }
        }
    }
}