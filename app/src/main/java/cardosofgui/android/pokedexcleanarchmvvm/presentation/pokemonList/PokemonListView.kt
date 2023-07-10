package cardosofgui.android.pokedexcleanarchmvvm.presentation.pokemonList

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cardosofgui.android.pokedexcleanarchmvvm.R
import cardosofgui.android.pokedexcleanarchmvvm.application.PokemonDetailsActivity
import cardosofgui.android.pokedexcleanarchmvvm.application.PokemonListActivity
import cardosofgui.android.pokedexcleanarchmvvm.presentation.pokemonList.components.PokemonCard
import org.koin.androidx.compose.getViewModel

/**
 * Composable que exibe a lista de Pokémon.
 *
 * @param modifier O modificador para personalizar a aparência e o comportamento da lista.
 * @param viewModel O ViewModel utilizado para obter os dados da lista de Pokémon.
 */
@SuppressLint("StateFlowValueCalledInComposition")
@Composable
internal fun PokemonListActivity.PokemonListView(
    modifier: Modifier = Modifier,
    viewModel: PokemonListViewModel = getViewModel()
) {
    Column(modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Icon(
                imageVector = ImageVector
                    .vectorResource(
                        id = R.drawable.pokeball
                    ),
                contentDescription = "Pokeball",
                tint = MaterialTheme.colorScheme.onBackground,
                modifier = Modifier
                    .size(24.dp)
            )

            Text(
                text = "Pokédex",
                color = MaterialTheme.colorScheme.onBackground,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(start = 16.dp)
            )
        }

        Text(
            text = "Bem vindo de volta, treinador!",
            color = MaterialTheme.colorScheme.onBackground,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            modifier = Modifier
                .padding(start = 16.dp, bottom = 16.dp)
        )

        AllPokemonsList(
            viewModel = viewModel
        )
    }
}

/**
 * Composable que exibe a lista de todos os Pokémon.
 *
 * @param modifier O modificador para personalizar a aparência e o comportamento da lista.
 * @param viewModel O ViewModel utilizado para obter os dados da lista de Pokémon.
 */
@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
internal fun PokemonListActivity.AllPokemonsList(
    modifier: Modifier = Modifier,
    viewModel: PokemonListViewModel
) {
    val pokemonList by viewModel.pokemonList.collectAsStateWithLifecycle()

    Box(
        modifier = modifier
            .padding(4.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(MaterialTheme.colorScheme.onBackground)
            .fillMaxSize()
    ) {
        Column {
            LazyColumn {
                itemsIndexed(pokemonList) {index, pokemon ->
                    pokemon?.let {
                        PokemonCard(
                            pokemon = pokemon,
                            modifier = Modifier.padding(
                                4.dp
                            ),
                            onClickPokemon = {
                                pokemon.id?.let {
                                    startActivity(
                                        PokemonDetailsActivity
                                            .getStartIntent(
                                                context = this@AllPokemonsList,
                                                pokemonId = pokemon.id
                                            )
                                    )
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}