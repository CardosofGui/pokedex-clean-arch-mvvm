package cardosofgui.android.pokedexcleanarchmvvm.domain.entity

/**
 * Classe que representa as estatísticas de um Pokémon.
 *
 * @param id O ID da estatística.
 * @param baseStat O valor base da estatística.
 * @param stat A estatística correspondente.
 */
data class Stats(
    val id: Long? = null,
    val baseStat: Long? = null,
    val stat: Stat? = null
)

/**
 * Classe que representa uma estatística de um Pokémon.
 *
 * @param name O nome da estatística.
 */
data class Stat(
    val name: String? = null
)
