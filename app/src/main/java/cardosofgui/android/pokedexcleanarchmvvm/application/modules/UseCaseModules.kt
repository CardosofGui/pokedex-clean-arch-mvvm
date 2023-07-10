package cardosofgui.android.pokedexcleanarchmvvm.application.modules

import cardosofgui.android.pokedexcleanarchmvvm.domain.usecase.FavoritePokemonUseCase
import cardosofgui.android.pokedexcleanarchmvvm.domain.usecase.GetPokemonUseCase
import org.koin.dsl.module

/**
 * Módulo de injeção de dependência relacionado aos casos de uso do aplicativo.
 */
val useCaseModules = module {
    /**
     * Retorna uma instância do [GetPokemonUseCase] que realiza a lógica de obtenção de dados de Pokémon.
     *
     * @return Instância do [GetPokemonUseCase].
     */
    factory {
        GetPokemonUseCase(
            pokemonRepository = get()
        )
    }

    /**
     * Retorna uma instância do [FavoritePokemonUseCase] que realiza a lógica de favoritar/desfavoritar um Pokémon.
     *
     * @return Instância do [FavoritePokemonUseCase].
     */
    factory {
        FavoritePokemonUseCase(
            pokemonRepository = get()
        )
    }
}