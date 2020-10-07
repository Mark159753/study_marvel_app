package com.example.data.datasourcess.remote.api

import com.example.data.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.math.BigInteger
import java.security.MessageDigest

class AuthInterceptor:Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val ts = System.currentTimeMillis().toString()
        val hashKey = generateHashKey(ts, BuildConfig.PUBLIC_API_KEY, BuildConfig.PRIVATE_API_KEY)

        val oldUrl = chain.request()
            .url
            .newBuilder()
            .addQueryParameter(TIMESTAMP, ts)
            .addQueryParameter(API_KEY, BuildConfig.PUBLIC_API_KEY)
            .addQueryParameter(HASH_KEY, hashKey)
            .build()
        val newUrl = chain.request()
            .newBuilder()
            .url(oldUrl)
            .build()
        return chain.proceed(newUrl)
    }

    private fun generateHashKey(ts:String, publicKey:String, privateKey:String):String{
        val key = ts + privateKey + publicKey
        return key.md5
    }

    private val String.md5:String
        get() {
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1, md.digest(toByteArray())).toString(16).padStart(32, '0')
        }

    companion object{
        private const val TIMESTAMP = "ts"
        private const val API_KEY = "apikey"
        private const val HASH_KEY = "hash"
    }
}