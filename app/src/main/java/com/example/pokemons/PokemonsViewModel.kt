package com.example.pokemons

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.pokemons.data.PokemonsRepository
import java.io.IOException
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.launch
import retrofit2.HttpException

class PokemonsViewModel(private val pokemonsRepository: PokemonsRepository) : ViewModel() {
    var uiState: PokemonsUiState by mutableStateOf(PokemonsUiState.Loading)
        private set

    init {
        getPokemons()
    }

    fun getPokemons() {
        viewModelScope.launch {
            uiState = PokemonsUiState.Loading

//            Log.d("PokemonsDebug", pokemonsRepository.getPokemons().toString());
            uiState = try {
                PokemonsUiState.Success(pokemonsRepository.getPokemons().results)
            } catch (e: IOException) {
                PokemonsUiState.Error
            } catch (e: HttpException) {
                PokemonsUiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as PokemonsApplication)
                val pokemonsRepository = application.container.pokemonsRepository
                PokemonsViewModel(pokemonsRepository = pokemonsRepository)
            }
        }
    }
}