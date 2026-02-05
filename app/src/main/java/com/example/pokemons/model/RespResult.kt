package com.example.pokemons.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RespResult(
//    @SerialName(value = "name")
//    val pokemonName: String,
//    @SerialName(value = "url")
//    val pokemonDetailURL: String
    val name: String,
    val url: String
)