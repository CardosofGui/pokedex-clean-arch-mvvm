package cardosofgui.android.pokedexcleanarchmvvm.application.modules

import cardosofgui.android.pokedexcleanarchmvvm.presentation.pokemonDetails.PokemonDetailsViewModel
import cardosofgui.android.pokedexcleanarchmvvm.presentation.pokemonList.PokemonListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Módulo de injeção de dependência relacionado aos ViewModels do aplicativo.
 */
val viewModelModules = module {
    /**
     * Retorna uma instância do [PokemonListViewModel] que atua como ViewModel para a lista de Pokémon.
     *
     * @return Instância do [PokemonListViewModel].
     */
    viewModel {
        PokemonListViewModel(
            getPokemonUseCase = get()
        )
    }

    /**
     * Retorna uma instância do [PokemonDetailsViewModel] que atua como ViewModel para os detalhes de um Pokémon específico.
     *
     * @param pokemonId ID do Pokémon.
     * @return Instância do [PokemonDetailsViewModel].
     */
    viewModel { (pokemonId: Long) ->
        PokemonDetailsViewModel(
            getPokemonUseCase = get(),
            favoritePokemonUseCase = get(),
            pokemonId = pokemonId
        )
    }
}