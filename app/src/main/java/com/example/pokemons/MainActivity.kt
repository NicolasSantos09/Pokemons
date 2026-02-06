package com.example.pokemons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.pokemons.model.Pokemon
import com.example.pokemons.ui.theme.PokemonsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokemonsTheme {
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    PokemonsApp()
//                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    PokemonsApp()
                }
            }
        }
    }
}

sealed interface PokemonsUiState {
    data class Success(val pokemons: List<Pokemon>) : PokemonsUiState
    object Error : PokemonsUiState
    object Loading : PokemonsUiState
}