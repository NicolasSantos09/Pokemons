package com.example.pokemons

import android.app.Application
import com.example.pokemons.data.AppContainer
import com.example.pokemons.data.DefaultAppContainer

class PokemonsApplication: Application() {
    /** AppContainer instance used by the rest of classes to obtain dependencies */
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}