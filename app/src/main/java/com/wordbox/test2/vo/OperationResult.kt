package com.wordbox.test2.vo

sealed class OperationResult<out T> {
    data class Success<T>(val data: T) : OperationResult<T>()
    data class Failure(val exception: Exception) : OperationResult<Nothing>()
}