package com.example.pokemons.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokemons.model.Pokemon
import com.example.pokemons.model.PokemonType
import com.example.pokemons.model.PokeType
import com.example.pokemons.model.RespResult
import com.example.pokemons.model.Sprites
import com.example.pokemons.ui.theme.PokemonsTheme

@Composable
fun PokemonsGridScreen(
    pokemons: List<Pokemon>,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier.padding(horizontal = 4.dp),
        contentPadding = contentPadding,
    ) {
        items(
            items = pokemons,
//            key = { pokemon -> pokemon.pokemonName }
        ) { pokemon ->
            PokemonCard(
                pokemon,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .aspectRatio(1.5f)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhotosGridScreenPreview() {
    PokemonsTheme {
        val mockData = List(10) {
            Pokemon(
                id = 123,
                order = 1,
                name = "bulbasaur",
                sprites = Sprites(
                    frontDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/1.png",
                    backDefault = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/1.png"
                ),
                types = listOf(
                    PokemonType(
                        slot=1,
                        type= PokeType(name="grass")
                    ),
                    PokemonType(
                        slot=2,
                        type= PokeType(name="poison")
                    )
                )
            )
        }
        PokemonsGridScreen(mockData)
    }
}