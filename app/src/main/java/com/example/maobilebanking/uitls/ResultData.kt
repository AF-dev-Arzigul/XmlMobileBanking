package com.example.maobilebanking.uitls



sealed class ResultData<out T> {
    data class Success<T>(val data: T) : ResultData<T>()
    data class Error(val message: String) : ResultData<Nothing>()
}