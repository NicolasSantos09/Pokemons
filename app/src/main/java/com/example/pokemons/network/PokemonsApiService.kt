package com.example.pokemons.network

import com.example.pokemons.model.PokemonResp
import retrofit2.http.GET

/**
 * A public interface that exposes the [getPokemons] method
 */
interface PokemonsApiService {
    /**
     * Returns a [List] of [Pokemons] and this method can be called from a Coroutine.
     */
    @GET("pokemon")
    suspend fun getPokemons(): PokemonResp
}