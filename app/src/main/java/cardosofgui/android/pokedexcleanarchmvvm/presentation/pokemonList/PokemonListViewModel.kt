package cardosofgui.android.pokedexcleanarchmvvm.presentation.pokemonList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cardosofgui.android.pokedexcleanarchmvvm.domain.entity.Pokemon
import cardosofgui.android.pokedexcleanarchmvvm.domain.usecase.GetPokemonUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

/**
 * ViewModel responsável por fornecer dados para a lista de Pokémon.
 *
 * @param getPokemonUseCase O caso de uso responsável por obter a lista de Pokémon.
 */
class PokemonListViewModel(
    private val getPokemonUseCase: GetPokemonUseCase,
): ViewModel() {

    /**
     * Fluxo de estado que contém a lista de Pokémon.
     */
    val pokemonList = MutableStateFlow(emptyList<Pokemon?>())

    /**
     * Fluxo de estado que indica se a lista de Pokémon está sendo carregada.
     */
    val isLoading = MutableStateFlow(true)

    private var limit: Long = 10000
    private var offset: Long = 0

    init {
        getPokemonList()
    }

    /**
     * Obtém a lista de Pokémon por meio do caso de uso correspondente.
     */
    private fun getPokemonList() {
        viewModelScope.launch {
            setIsLoading(true)

            val result = getPokemonUseCase.getPokemonList(
                limit = limit,
                offset = offset
            )

            setPokemonList(result)

            setIsLoading(false)
        }
    }

    /**
     * Define o estado de carregamento da lista de Pokémon.
     *
     * @param value O valor de estado de carregamento a ser definido.
     */
    private fun setIsLoading(value: Boolean) { isLoading.value = value }

    /**
     * Define a lista de Pokémon.
     *
     * @param value A lista de Pokémon a ser definida.
     */
    private fun setPokemonList(value: List<Pokemon?>) { pokemonList.value = value }
}
