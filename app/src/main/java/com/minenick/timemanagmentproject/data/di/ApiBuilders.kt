package com.minenick.timemanagmentproject.data.di

import android.os.Build
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.internal.http2.ConnectionShutdownException
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.io.IOException
import java.net.SocketTimeoutException
import java.net.UnknownHostException
import java.util.concurrent.TimeUnit

object ApiBuilders {

    //API TIMEOUT
    const val TIME_OUT = 30L


    inline fun <reified T> getService(host: String): T {
        val json = Json {
            ignoreUnknownKeys = true
            prettyPrint = true
            isLenient = true
            allowSpecialFloatingPointValues = true
            coerceInputValues = true
            encodeDefaults = true
        }
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder().client(
            OkHttpClient.Builder()
                .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
                .callTimeout(TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(Interceptor { chain ->
                    val original = chain.request()

                    try {

                        val vmVersion = System.getProperty("java.vm.version")

                        val isArt = try {
                            (System.getProperty("java.vm.version")
                                ?.split(".".toRegex())?.toTypedArray()?.get(0)
                                ?.toInt() ?: 0) >= 2
                        } catch (e: NumberFormatException) {
                            // we suppress the exception and fall back to checking only for current ART
                            System.getProperty("java.vm.version")!!.startsWith("2.")
                        }

                        val vm = if (isArt) "ART" else "Dalvik"

                        val request = original.newBuilder()
                            .header("device", "android")
                            .header(
                                "User-Agent",
                                "Siclo+ $vm/$vmVersion (Linux; U; Android API${Build.VERSION.SDK_INT}; DeviceId/${Build.ID})"
                            )
                            .method(original.method, original.body)
                            .build()

                        return@Interceptor chain.proceed(request)

                    } catch (e: Exception) {
                        e.printStackTrace()
                        val msg = when (e) {
                            is SocketTimeoutException -> "Timeout - Please check your internet connection"
                            is UnknownHostException -> "Unable to make a connection. Please check your internet"
                            is ConnectionShutdownException -> "Connection shutdown. Please check your internet"
                            is IOException -> "Server is unreachable, please try again later."
                            is IllegalStateException -> "${e.message}"
                            else -> "${e.message}"
                        }

                        return@Interceptor Response.Builder()
                            .request(original)
                            .protocol(Protocol.HTTP_1_1)
                            .code(999)
                            .message(msg)
                            .body("{${e}}".toResponseBody(null)).build()
                    }
                })
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
        )
            .addConverterFactory(json.asConverterFactory(contentType))
            .baseUrl(host)
            .build()
            .create(T::class.java)
    }
}