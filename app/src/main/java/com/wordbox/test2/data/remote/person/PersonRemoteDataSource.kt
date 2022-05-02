package com.wordbox.test2.data.remote.person

import com.wordbox.test2.data.remote.api.PersonService
import com.wordbox.test2.data.remote.model.PersonRemote
import com.wordbox.test2.vo.OperationResult

class PersonRemoteDataSource(
    private val api: PersonService
) {
    suspend fun getAll(): OperationResult<List<PersonRemote>> {
        return OperationResult.Success(api.getAll().results)
    }
}