package com.example.pokemons.ui.screens

import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokemons.model.RespResult
import com.example.pokemons.ui.theme.PokemonsTheme

@Composable
fun PokemonCard(pokemon: RespResult, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Text(text = pokemon.name)

        Text(text = pokemon.url)
//        AsyncImage(
//            model = ImageRequest.Builder(context = LocalContext.current).data(pokemon.pokemonDetailURL)
//                .crossfade(true).build(),
//            error = painterResource(R.drawable.ic_broken_image),
//            placeholder = painterResource(R.drawable.loading_img),
//            contentDescription = stringResource(R.string.pokemons),
//            contentScale = ContentScale.Crop,
//            modifier = Modifier.fillMaxWidth()
//        )
    }
}

@Preview(showBackground = true)
@Composable
fun PokemonCardPreview() {
    PokemonsTheme {
        val mockData = RespResult(
            name = "bulbasaur",
            url = "https://pokeapi.co/api/v2/pokemon/1/"
        )
        PokemonCard(
            pokemon = mockData
        )
    }
}