package com.example.pokemons.data

import com.example.pokemons.model.PokemonResp
import com.example.pokemons.network.PokemonsApiService

/**
 * Network Implementation of Repository that fetch pokemons list from pokemons API.
 */
class NetworkPokemonsRepository(private val pokemonsAPIService: PokemonsApiService): PokemonsRepository {
    override suspend fun getPokemons(): PokemonResp = pokemonsAPIService.getPokemons()
}