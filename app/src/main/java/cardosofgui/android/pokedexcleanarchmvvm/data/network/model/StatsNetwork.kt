package cardosofgui.android.pokedexcleanarchmvvm.data.network.model

import cardosofgui.android.pokedexcleanarchmvvm.domain.entity.Stat
import cardosofgui.android.pokedexcleanarchmvvm.domain.entity.Stats
import kotlinx.serialization.Serializable

/**
 * Classe que representa as estatísticas de um Pokémon na camada de rede.
 */
@Serializable
data class StatsNetwork(
    val base_stat: Long? = null,
    val stat: StatNetwork? = null
) {
    /**
     * Converte o objeto [StatsNetwork] em um objeto [Stats] do domínio do aplicativo.
     *
     * @return Objeto [Stats] do domínio do aplicativo.
     */
    fun provideToModel() = Stats(
        baseStat = this.base_stat,
        stat = stat?.provideToModel()
    )
}

/**
 * Classe que representa uma estatística de um Pokémon na camada de rede.
 */
@Serializable
data class StatNetwork(
    val name: String? = null
) {
    /**
     * Converte o objeto [StatNetwork] em um objeto [Stat] do domínio do aplicativo.
     *
     * @return Objeto [Stat] do domínio do aplicativo.
     */
    fun provideToModel() = Stat(
        name = this.name
    )
}
