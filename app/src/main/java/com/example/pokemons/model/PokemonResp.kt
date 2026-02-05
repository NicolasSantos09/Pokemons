package com.example.pokemons.model

import kotlinx.serialization.Serializable

@Serializable
data class PokemonResp(
    val count: Int,
    val next: String,
    val previous: String? = null,
    val results: List<RespResult>
)