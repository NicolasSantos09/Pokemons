package com.example.pokemons.data

import com.example.pokemons.model.Pokemon
import com.example.pokemons.model.PokemonResp
import com.example.pokemons.network.PokemonsApiService
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope

/**
 * Network Implementation of Repository that fetch pokemons list from pokemons API.
 */
class NetworkPokemonsRepository(private val pokemonsAPIService: PokemonsApiService): PokemonsRepository {
    override suspend fun getPokemons(): List<Pokemon> = coroutineScope {
        val pokemonsList = pokemonsAPIService.getPokemons()
        val deferredDetails = pokemonsList.results.map { pokemonDetail ->
            async {
                pokemonsAPIService.getPokemonDetail(pokemonDetail.pokemonDetailURL)
            }
        }
        deferredDetails.awaitAll()

    }
}