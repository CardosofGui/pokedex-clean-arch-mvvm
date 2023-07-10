package cardosofgui.android.pokedexcleanarchmvvm.data.network.service

import cardosofgui.android.pokedexcleanarchmvvm.data.network.model.PokemonNetwork
import cardosofgui.android.pokedexcleanarchmvvm.domain.entity.Pokemon
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.serialization.Serializable

/**
 * Cliente para interação com a API de Pokémon.
 *
 * @param ktorClient O cliente HTTP Ktor utilizado para realizar as requisições.
 */
class PokemonApiClient(
    private val ktorClient: HttpClient
) {
    /**
     * Obtém um Pokémon por ID.
     *
     * @param pokemonId O ID do Pokémon a ser obtido.
     * @return O objeto [Pokemon] correspondente ao Pokémon obtido.
     */
    suspend fun getPokemonById(pokemonId: Long? = null): Pokemon {
        val response: PokemonNetwork = ktorClient.get("https://pokeapi.co/api/v2/pokemon/$pokemonId").body()
        return response.provideToModel()
    }

    /**
     * Obtém a lista de Pokémon.
     *
     * @param limit O limite de resultados a ser retornado.
     * @param offset O deslocamento para a lista de resultados.
     * @return A lista de objetos [Pokemon] correspondente à lista de Pokémon obtida.
     */
    suspend fun getPokemonList(limit: Long?, offset: Long?): List<Pokemon>? {
        val response: ResultGeneric<PokemonNetwork> = ktorClient.get("https://pokeapi.co/api/v2/pokemon/") {
            parameter("offset", offset)
            parameter("limit", limit)
        }.body()

        return response.results?.map { it.provideToModel() }
    }
}

/**
 * Classe genérica para representar um resultado comuns de APIs que retornam uma lista de resultados.
 *
 * @param T O tipo de dado dos resultados.
 */
@Serializable
data class ResultGeneric<T>(
    val count: Long? = null,
    val next: String? = null,
    val previous: String? = null,
    val results: List<T>? = null
)
