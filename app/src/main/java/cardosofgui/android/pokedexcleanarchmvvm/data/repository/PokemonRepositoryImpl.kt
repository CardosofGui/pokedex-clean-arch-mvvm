package cardosofgui.android.pokedexcleanarchmvvm.data.repository

import cardosofgui.android.pokedexcleanarchmvvm.data.database.dao.FavoriteDao
import cardosofgui.android.pokedexcleanarchmvvm.data.database.model.FavoriteTb
import cardosofgui.android.pokedexcleanarchmvvm.data.network.service.PokemonApiClient
import cardosofgui.android.pokedexcleanarchmvvm.domain.entity.Pokemon
import cardosofgui.android.pokedexcleanarchmvvm.domain.interfaces.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Implementação concreta da interface [PokemonRepository].
 *
 * @param favoriteDao O DAO [FavoriteDao] para acessar as operações relacionadas aos favoritos.
 * @param pokemonApiClient O cliente da API de Pokémon [PokemonApiClient] para obter os dados dos Pokémon.
 */
class PokemonRepositoryImpl(
    private val favoriteDao: FavoriteDao,
    private val pokemonApiClient: PokemonApiClient
) : PokemonRepository {
    /**
     * Obtém um Pokémon por ID.
     *
     * @param id O ID do Pokémon.
     * @return Um [Flow] que emite o objeto [Pokemon] correspondente ao Pokémon obtido, ou nulo se não encontrado.
     */
    override suspend fun getPokemonById(id: Long): Flow<Pokemon?> {
        val pokemon = pokemonApiClient.getPokemonById(pokemonId = id)

        return favoriteDao.queryFavorite(id).map { favoriteStatus ->
            pokemon.copy(
                favoriteStatus = favoriteStatus != null
            )
        }
    }

    /**
     * Obtém uma lista de Pokémon.
     *
     * @param limit O limite de resultados a ser retornado.
     * @param offset O deslocamento para a lista de resultados.
     * @return A lista de objetos [Pokemon] correspondente à lista de Pokémon obtida.
     */
    override suspend fun getPokemonList(limit: Long, offset: Long): List<Pokemon?> {
        val pokemonList = pokemonApiClient.getPokemonList(limit = limit, offset = offset)

        return pokemonList ?: emptyList()
    }

    /**
     * Adiciona um Pokémon aos favoritos.
     *
     * @param pokemonId O ID do Pokémon a ser adicionado aos favoritos.
     */
    override suspend fun addFavoritePokemon(pokemonId: Long?) {
        pokemonId?.let { id ->
            favoriteDao.insertFavorite(
                FavoriteTb(
                    pokemonId = id
                )
            )
        }
    }

    /**
     * Remove um Pokémon dos favoritos.
     *
     * @param pokemonId O ID do Pokémon a ser removido dos favoritos.
     */
    override suspend fun removeFavoritePokemon(pokemonId: Long?) {
        pokemonId?.let { id ->
            favoriteDao.deleteFavorite(id)
        }
    }
}
