package com.example.pokemons.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * This data class defines a Pokemon
 */
@Serializable
data class Pokemon(
    val id: Int,
    val order: Int,
    val name: String,
    val sprites: Sprites,
    val types: List<PokemonType>
)

@Serializable
data class Sprites(
    @SerialName(value = "front_default")
    val frontDefault: String,
    @SerialName(value = "back_default")
    val backDefault: String,
)

@Serializable
data class PokemonType(
    val slot: Int,
    val type: PokeType,
    @SerialName(value = "img_src")
    val imgSrc: String
)

@Serializable
data class PokeType(
    val name: String
)