package com.example.data.datasourcess.remote

sealed class LoadStatus<out T> {
    data class Success<T>(val data:T): LoadStatus<T>()
    data class ConnectionError(val msg:String?, val e: Throwable?): LoadStatus<Nothing>()
    data class Error(val msg:String?, val e:Throwable?): LoadStatus<Nothing>()
}