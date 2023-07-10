package cardosofgui.android.pokedexcleanarchmvvm.domain.interfaces.repository

import cardosofgui.android.pokedexcleanarchmvvm.domain.entity.Pokemon
import kotlinx.coroutines.flow.Flow

/**
 * Interface que define os métodos para acessar os dados dos Pokémon.
 */
interface PokemonRepository {
    /**
     * Obtém um Pokémon por ID.
     *
     * @param id O ID do Pokémon.
     * @return Um [Flow] que emite o objeto [Pokemon] correspondente ao Pokémon obtido, ou nulo se não encontrado.
     */
    suspend fun getPokemonById(id: Long): Flow<Pokemon?>

    /**
     * Obtém uma lista de Pokémon.
     *
     * @param limit O limite de resultados a ser retornado.
     * @param offset O deslocamento para a lista de resultados.
     * @return A lista de objetos [Pokemon] correspondente à lista de Pokémon obtida.
     */
    suspend fun getPokemonList(limit: Long, offset: Long): List<Pokemon?>

    /**
     * Adiciona um Pokémon aos favoritos.
     *
     * @param pokemonId O ID do Pokémon a ser adicionado aos favoritos.
     */
    suspend fun addFavoritePokemon(pokemonId: Long?)

    /**
     * Remove um Pokémon dos favoritos.
     *
     * @param pokemonId O ID do Pokémon a ser removido dos favoritos.
     */
    suspend fun removeFavoritePokemon(pokemonId: Long?)
}
