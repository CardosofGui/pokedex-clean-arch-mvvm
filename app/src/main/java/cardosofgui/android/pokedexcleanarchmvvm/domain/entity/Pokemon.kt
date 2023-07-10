package cardosofgui.android.pokedexcleanarchmvvm.domain.entity

/**
 * Classe que representa um Pokémon.
 *
 * @param id O ID do Pokémon.
 * @param name O nome do Pokémon.
 * @param mainImage A URL da imagem principal do Pokémon.
 * @param height A altura do Pokémon.
 * @param weight O peso do Pokémon.
 * @param types A lista de tipos do Pokémon.
 * @param stats A lista de estatísticas do Pokémon.
 * @param favoriteStatus O status de favorito do Pokémon.
 */
data class Pokemon(
    val id: Long? = null,
    val name: String? = null,
    val mainImage: String? = null,
    val height: Long? = null,
    val weight: Long? = null,
    val types: List<Types>? = null,
    val stats: List<Stats>? = null,
    val favoriteStatus: Boolean = false
)
