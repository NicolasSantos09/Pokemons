package com.example.pokemons.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pokemons.R
import com.example.pokemons.model.PokeType
import com.example.pokemons.model.Pokemon
import com.example.pokemons.model.PokemonType
import com.example.pokemons.model.Sprites
import com.example.pokemons.ui.theme.PokemonsTheme

@Composable
fun PokemonCard(pokemon: Pokemon, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier.padding(top = 8.dp, start = 8.dp)
        )
        {
            Text(text = pokemon.name)

            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(pokemon.sprites.frontDefault)
                    .crossfade(true).build(),
                error = painterResource(R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_img),
                contentDescription = stringResource(R.string.pokemons),
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonCardPreview() {
    PokemonsTheme {
        val mockData = Pokemon(
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
        PokemonCard(
            pokemon = mockData
        )
    }
}