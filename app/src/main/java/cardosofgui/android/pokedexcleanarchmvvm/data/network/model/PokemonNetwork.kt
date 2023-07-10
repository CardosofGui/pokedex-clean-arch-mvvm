package cardosofgui.android.pokedexcleanarchmvvm.data.network.model

import cardosofgui.android.pokedexcleanarchmvvm.domain.entity.Pokemon
import kotlinx.serialization.Serializable

/**
 * Classe que representa um Pokémon na camada de rede.
 */
@Serializable
data class PokemonNetwork(
    val id: Long? = null,
    val name: String? = null,
    val url: String? = null,
    val height: Long? = null,
    val weight: Long? = null,
    val types: List<TypesNetwork>? = null,
    val stats: List<StatsNetwork>? = null
) {
    /**
     * Converte o objeto [PokemonNetwork] em um objeto [Pokemon] do domínio do aplicativo.
     *
     * @return Objeto [Pokemon] do domínio do aplicativo.
     */
    fun provideToModel(): Pokemon {
        val urlSplit = url?.split("/") ?: emptyList()
        val idByUrlSplit = urlSplit.getOrNull(urlSplit.size - 2)?.toLong()

        return Pokemon(
            id = this.id ?: idByUrlSplit,
            name = this.name,
            mainImage = getImageUrl(this.id ?: idByUrlSplit ?: 0),
            height = this.height,
            weight = this.weight,
            types = types?.map { it.provideToModel() },
            stats = stats?.map { it.provideToModel() }
        )
    }
}

/**
 * Retorna a URL da imagem principal do Pokémon com base em seu ID.
 *
 * @param id O ID do Pokémon.
 * @return A URL da imagem principal do Pokémon.
 */
private fun getImageUrl(id: Long) =
    "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"

