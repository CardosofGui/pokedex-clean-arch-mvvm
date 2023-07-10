package cardosofgui.android.pokedexcleanarchmvvm.application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import cardosofgui.android.pokedexcleanarchmvvm.presentation.PokedexCleanArchMVVMTheme
import cardosofgui.android.pokedexcleanarchmvvm.presentation.pokemonList.PokemonListView

class PokemonListActivity : ComponentActivity() {

    /**
     * Método de criação da activity.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configura o conteúdo da activity com Jetpack Compose
        setContent {
            PokedexCleanArchMVVMTheme {
                PokemonListView(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxSize()
                )
            }
        }
    }
}
