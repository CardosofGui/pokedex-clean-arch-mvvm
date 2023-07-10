package cardosofgui.android.pokedexcleanarchmvvm.application

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import cardosofgui.android.pokedexcleanarchmvvm.presentation.PokedexCleanArchMVVMTheme
import cardosofgui.android.pokedexcleanarchmvvm.presentation.pokemonDetails.PokemonDetailsView
import cardosofgui.android.pokedexcleanarchmvvm.presentation.pokemonDetails.PokemonDetailsViewModel
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

/**
 * Activity responsável por exibir os detalhes de um Pokémon.
 */
class PokemonDetailsActivity : ComponentActivity() {

    /**
     * Método de criação da activity.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Obtém o ID do Pokémon dos extras da intent
        val pokemonId = if(intent.extras != null) {
            if (intent.hasExtra(POKEMON_ID_PARAM)) {
                intent.getLongExtra(POKEMON_ID_PARAM, 0)
            } else null
        } else null

        // Configura o conteúdo da activity com Jetpack Compose
        setContent {
            // Obtém a instância do ViewModel [PokemonDetailsViewModel] com Koin, passando o ID do Pokémon como parâmetro
            val detailsViewModel = getViewModel<PokemonDetailsViewModel> {
                parametersOf(pokemonId)
            }

            // Renderiza a tela dos detalhes do Pokémon
            PokedexCleanArchMVVMTheme {
                PokemonDetailsView(
                    viewModel = detailsViewModel
                )
            }
        }
    }

    companion object {
        const val POKEMON_ID_PARAM = "POKEMON_ID_PARAM"

        /**
         * Método estático para obter uma intent de início da [PokemonDetailsActivity].
         *
         * @param context O contexto da aplicação.
         * @param pokemonId O ID do Pokémon.
         * @return Intent de início da [PokemonDetailsActivity].
         */
        fun getStartIntent(
            context: Context,
            pokemonId: Long
        ): Intent {
            return Intent(
                context,
                PokemonDetailsActivity::class.java
            ).putExtra(POKEMON_ID_PARAM, pokemonId)
        }
    }
}