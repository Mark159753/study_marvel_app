package com.example.data.datasourcess.remote.api

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.data.exception.NoConnectivityException
import okhttp3.Interceptor
import okhttp3.Response


class NetworkConnectionInterceptor(context: Context):Interceptor {

    private val connectivityManager by lazy {
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isConnected())
            throw NoConnectivityException()
        val builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

    private fun isConnected(): Boolean {
        var result = false
            val networkCapabilities = connectivityManager.activeNetwork ?: return false
            val actNw =
                connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false
            result = when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                else -> false
            }
        return result
    }
}