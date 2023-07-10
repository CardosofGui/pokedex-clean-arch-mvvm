package cardosofgui.android.pokedexcleanarchmvvm.application.modules

import cardosofgui.android.pokedexcleanarchmvvm.data.repository.PokemonRepositoryImpl
import cardosofgui.android.pokedexcleanarchmvvm.domain.interfaces.repository.PokemonRepository
import org.koin.dsl.module

/**
 * Módulo de injeção de dependência relacionado aos repositórios do aplicativo.
 */
val repositoryModules = module {
    /**
     * Retorna uma instância do [PokemonRepository] que utiliza a implementação [PokemonRepositoryImpl].
     *
     * @return Instância do [PokemonRepository].
     */
    single {
        PokemonRepositoryImpl(
            pokemonApiClient = get(),
            favoriteDao = get()
        ) as PokemonRepository
    }
}
