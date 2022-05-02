package com.wordbox.test2.presentation.person.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wordbox.test2.domain.use_case.GetAllPersonUseCase
import com.wordbox.test2.presentation.person.mapper.toModel
import com.wordbox.test2.presentation.person.model.PersonModel
import com.wordbox.test2.vo.OperationResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PersonViewModel(
    private val getAllPersonUseCase: GetAllPersonUseCase
) : ViewModel() {

    private var mutablePersons = MutableLiveData<List<PersonModel>>()
    val persons get() = mutablePersons

    fun getAll() {
        viewModelScope.launch {
            val result = withContext(Dispatchers.IO) {
                getAllPersonUseCase.execute()
            }
            when (result) {
                is OperationResult.Success -> {
                    val data = result.data.toModel()
                    mutablePersons.value = data
                }
                is OperationResult.Failure -> {

                }
            }
        }
    }
}