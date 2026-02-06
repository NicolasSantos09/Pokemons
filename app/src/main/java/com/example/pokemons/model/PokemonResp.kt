package com.example.pokemons.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PokemonResp(
    val count: Int,
    val next: String,
    val previous: String? = null,
    val results: List<RespResult>
)

@Serializable
data class RespResult(
    @SerialName(value = "name")
    val pokemonName: String,
    @SerialName(value = "url")
    val pokemonDetailURL: String
)