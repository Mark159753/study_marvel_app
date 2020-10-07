package com.example.domain.model


sealed class Status<out T> {
    data class Success<T>(val data:T): Status<T>()
    data class ConnectionError(val msg:String?): Status<Nothing>()
    data class UnknownError(val msg:String?): Status<Nothing>()
    object Loading: Status<Nothing>()
}