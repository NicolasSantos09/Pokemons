package com.example.pokemons.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokemons.PokemonsUiState
import com.example.pokemons.model.PokeType
import com.example.pokemons.model.Pokemon
import com.example.pokemons.model.PokemonType
import com.example.pokemons.model.Sprites
import com.example.pokemons.ui.theme.PokemonsTheme
import com.example.uicore.LoadingScreen

@Composable
fun HomeScreen(
    uiState: PokemonsUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    when (uiState) {
        is PokemonsUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is PokemonsUiState.Success -> PokemonsGridScreen(
            uiState.pokemons,
            contentPadding = contentPadding,
            modifier = modifier.fillMaxWidth()
        )
        is PokemonsUiState.Error -> ErrorScreen(retryAction, modifier = modifier.fillMaxSize())
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
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
        HomeScreen(
            uiState = PokemonsUiState.Success(pokemons = mockData),
            retryAction = {}
        )
    }
}