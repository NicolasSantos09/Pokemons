package com.example.pokemons.data

import com.example.pokemons.network.PokemonsApiService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
//import kotlinx.serialization.ExperimentalSerializationApi
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class DefaultAppContainer : AppContainer {
    private val baseUrl = "https://pokeapi.co/api/v2/"

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        // Set the desired log level:
        // NONE: No logs
        // BASIC: Logs request method and URL, and response status
        // HEADERS: Logs request and response lines and their headers
        // BODY: Logs request and response lines, headers, and bodies (most verbose, best for debugging)
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor) // Add the interceptor
        // Optional: set timeouts
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    val json = Json {
        // Configure behavior like ignoring unknown keys if your data class is a subset of the JSON
        ignoreUnknownKeys = true
        // Allow for default values for missing fields without throwing an exception
        explicitNulls = false
    }
    val contentType = "application/json".toMediaType()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(json.asConverterFactory(contentType))
        .build()

    private val retrofitService: PokemonsApiService by lazy {
        retrofit.create(PokemonsApiService::class.java)
    }

    override val pokemonsRepository: PokemonsRepository by lazy {
        NetworkPokemonsRepository(retrofitService)
    }
}