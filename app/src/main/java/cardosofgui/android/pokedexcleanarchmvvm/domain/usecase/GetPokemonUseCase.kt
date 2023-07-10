package cardosofgui.android.pokedexcleanarchmvvm.domain.usecase

import cardosofgui.android.pokedexcleanarchmvvm.domain.entity.Pokemon
import cardosofgui.android.pokedexcleanarchmvvm.domain.interfaces.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow

/**
 * Caso de uso para obter dados de Pokémon.
 *
 * @param pokemonRepository O repositório [PokemonRepository] responsável pelo acesso aos dados dos Pokémon.
 */
class GetPokemonUseCase(
    private val pokemonRepository: PokemonRepository
) {
    /**
     * Obtém um Pokémon por ID.
     *
     * @param id O ID do Pokémon.
     * @return Um [Flow] que emite o objeto [Pokemon] correspondente ao Pokémon obtido, ou nulo se não encontrado.
     */
    suspend fun getPokemonById(id: Long): Flow<Pokemon?> {
        return pokemonRepository.getPokemonById(id = id)
    }

    /**
     * Obtém uma lista de Pokémon.
     *
     * @param limit O limite de resultados a ser retornado.
     * @param offset O deslocamento para a lista de resultados.
     * @return A lista de objetos [Pokemon] correspondente à lista de Pokémon obtida.
     */
    suspend fun getPokemonList(limit: Long, offset: Long): List<Pokemon?> {
        return pokemonRepository.getPokemonList(
            limit = limit,
            offset = offset
        )
    }
}
