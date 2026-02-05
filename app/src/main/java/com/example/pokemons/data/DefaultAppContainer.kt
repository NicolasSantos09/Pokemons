package com.example.pokemons.data

import com.example.pokemons.network.PokemonsApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
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

    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .build()

    private val retrofitService: PokemonsApiService by lazy {
        retrofit.create(PokemonsApiService::class.java)
    }

    override val pokemonsRepository: PokemonsRepository by lazy {
        NetworkPokemonsRepository(retrofitService)
    }
}