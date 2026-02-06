package com.example.pokemons.network

import com.example.pokemons.model.Pokemon
import com.example.pokemons.model.PokemonResp
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * A public interface that exposes the [getPokemons] method
 */
interface PokemonsApiService {
    /**
     * Returns a [List] of [Pokemons] and this method can be called from a Coroutine.
     */
    @GET("pokemon")
    suspend fun getPokemons(): PokemonResp

    @GET
    suspend fun getPokemonDetail(@Url url: String): Pokemon
}