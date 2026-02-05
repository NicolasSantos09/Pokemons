package com.example.pokemons.ui.screens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokemons.PokemonsUiState
import com.example.pokemons.model.RespResult
import com.example.pokemons.ui.theme.PokemonsTheme

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
        val mockData = List(1) {
            RespResult(
                name = "bulbasaur",
                url = "https://pokeapi.co/api/v2/pokemon/1/"
            )
        }
        HomeScreen(
            uiState = PokemonsUiState.Success(pokemons = mockData),
            retryAction = {}
        )
    }
}