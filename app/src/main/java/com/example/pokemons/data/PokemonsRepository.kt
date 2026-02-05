package com.example.pokemons.data

import com.example.pokemons.model.PokemonResp

/**
 * Repository that fetch pokemons list from pokemons API.
 */
interface PokemonsRepository {
    /** Fetches list of Pokemons from pokemons API */
    suspend fun getPokemons(): PokemonResp
}