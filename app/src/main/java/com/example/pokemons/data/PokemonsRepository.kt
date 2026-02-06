package com.example.pokemons.data

import com.example.pokemons.model.Pokemon
import com.example.pokemons.model.PokemonResp
import retrofit2.http.GET
import retrofit2.http.Url

/**
 * Repository that fetch pokemons list from pokemons API.
 */
interface PokemonsRepository {
    suspend fun getPokemons(): List<Pokemon>
}