package cardosofgui.android.pokedexcleanarchmvvm.presentation.pokemonDetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cardosofgui.android.pokedexcleanarchmvvm.domain.entity.Pokemon
import cardosofgui.android.pokedexcleanarchmvvm.domain.usecase.FavoritePokemonUseCase
import cardosofgui.android.pokedexcleanarchmvvm.domain.usecase.GetPokemonUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.util.Locale

/**
 * ViewModel responsável por fornecer dados e funcionalidades relacionadas à tela de detalhes de um Pokémon.
 *
 * @property getPokemonUseCase Caso de uso para obter os detalhes de um Pokémon.
 * @property favoritePokemonUseCase Caso de uso para adicionar ou remover um Pokémon favorito.
 * @property pokemonId ID do Pokémon para o qual os detalhes serão exibidos.
 */
class PokemonDetailsViewModel(
    private val getPokemonUseCase: GetPokemonUseCase,
    private val favoritePokemonUseCase: FavoritePokemonUseCase,
    var pokemonId: Long
): ViewModel() {

    val isLoading = MutableStateFlow(false)
    val pokemonDetails: MutableStateFlow<Pokemon?> = MutableStateFlow(null)

    init {
        collectPokemonDetails()
    }

    /**
     * Coleta os detalhes do Pokémon e atualiza o estado `pokemonDetails`.
     */
    private fun collectPokemonDetails() {
        viewModelScope.launch {
            setIsLoading(true)

            try {
                getPokemonUseCase.getPokemonById(pokemonId).collect {
                    setPokemonDetails(it)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                setIsLoading(false)
            }
        }
    }

    /**
     * Adiciona ou remove um Pokémon favorito com base no parâmetro `favorite`.
     *
     * @param favorite Indica se o Pokémon deve ser adicionado (`true`) ou removido (`false`) dos favoritos.
     */
    fun favoritePokemon(favorite: Boolean) {
        viewModelScope.launch {
            try {
                val currentPokemon = pokemonDetails.value ?: return@launch

                if(favorite) {
                    favoritePokemonUseCase.addFavoritePokemon(currentPokemon.id)
                } else {
                    favoritePokemonUseCase.removeFavoritePokemon(currentPokemon.id)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    /**
     * Atualiza o estado `pokemonDetails` com o valor fornecido.
     *
     * @param value O novo valor para o estado `pokemonDetails`.
     */
    private fun setPokemonDetails(value: Pokemon?) { pokemonDetails.value = value }

    /**
     * Atualiza o estado `isLoading` com o valor fornecido.
     *
     * @param value O novo valor para o estado `isLoading`.
     */
    private fun setIsLoading(value: Boolean) { isLoading.value = value }
}
