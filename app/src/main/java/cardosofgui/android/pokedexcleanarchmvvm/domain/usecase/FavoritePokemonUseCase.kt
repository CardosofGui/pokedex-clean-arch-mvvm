package cardosofgui.android.pokedexcleanarchmvvm.domain.usecase

import cardosofgui.android.pokedexcleanarchmvvm.domain.interfaces.repository.PokemonRepository

/**
 * Caso de uso para manipulação de Pokémon favoritos.
 *
 * @param pokemonRepository O repositório [PokemonRepository] responsável pelo acesso aos dados dos Pokémon.
 */
class FavoritePokemonUseCase(
    private val pokemonRepository: PokemonRepository
) {
    /**
     * Remove um Pokémon dos favoritos.
     *
     * @param pokemonId O ID do Pokémon a ser removido dos favoritos.
     */
    suspend fun removeFavoritePokemon(pokemonId: Long?) {
        pokemonRepository.removeFavoritePokemon(pokemonId)
    }

    /**
     * Adiciona um Pokémon aos favoritos.
     *
     * @param pokemonId O ID do Pokémon a ser adicionado aos favoritos.
     */
    suspend fun addFavoritePokemon(pokemonId: Long?) {
        pokemonRepository.addFavoritePokemon(pokemonId)
    }
}
