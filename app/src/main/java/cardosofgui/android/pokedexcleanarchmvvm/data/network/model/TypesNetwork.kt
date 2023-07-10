package cardosofgui.android.pokedexcleanarchmvvm.data.network.model

import cardosofgui.android.pokedexcleanarchmvvm.domain.entity.PokemonTypes
import cardosofgui.android.pokedexcleanarchmvvm.domain.entity.Type
import cardosofgui.android.pokedexcleanarchmvvm.domain.entity.Types
import kotlinx.serialization.Serializable

/**
 * Classe que representa os tipos de um Pokémon na camada de rede.
 */
@Serializable
data class TypesNetwork(
    val type: TypeNetwork
) {
    /**
     * Converte o objeto [TypesNetwork] em um objeto [Types] do domínio do aplicativo.
     *
     * @return Objeto [Types] do domínio do aplicativo.
     */
    fun provideToModel() = Types(
        this.type.provideToModel()
    )
}

/**
 * Classe que representa um tipo de um Pokémon na camada de rede.
 */
@Serializable
data class TypeNetwork(
    val name: String
) {
    /**
     * Converte o objeto [TypeNetwork] em um objeto [Type] do domínio do aplicativo.
     *
     * @return Objeto [Type] do domínio do aplicativo.
     */
    fun provideToModel() = Type(
        name = PokemonTypes.valueOf(this.name.uppercase())
    )
}
