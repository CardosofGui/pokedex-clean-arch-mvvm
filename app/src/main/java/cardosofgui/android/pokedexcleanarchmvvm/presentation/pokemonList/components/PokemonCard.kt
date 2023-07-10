package cardosofgui.android.pokedexcleanarchmvvm.presentation.pokemonList.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cardosofgui.android.pokedexcleanarchmvvm.domain.entity.Pokemon
import coil.compose.SubcomposeAsyncImage
import java.util.*

/**
 * Composable que exibe um cartão de um Pokémon.
 *
 * @param modifier O modificador para personalizar a aparência e o comportamento do cartão.
 * @param pokemon O objeto Pokémon a ser exibido no cartão.
 * @param onClickPokemon A função de retorno de chamada a ser acionada quando o cartão do Pokémon for clicado.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun PokemonCard(
    modifier: Modifier = Modifier,
    pokemon: Pokemon,
    onClickPokemon: (Long) -> Unit
) {
    Card(
        onClick = { onClickPokemon(pokemon.id ?: 0) },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = modifier
            .fillMaxWidth()
    ) {
        var pokemonImage by remember(pokemon) { mutableStateOf(pokemon.mainImage) }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SubcomposeAsyncImage(
                model = pokemonImage,
                contentDescription = "",
                contentScale = ContentScale.Fit,
                error = {
                    LaunchedEffect(Unit) {
                        pokemonImage = pokemon.mainImage
                    }
                },
                modifier = Modifier
                    .size(72.dp)
            )

            Column(
                modifier = Modifier.padding(start = 12.dp)
            ) {
                Text(
                    text = "#${pokemon.id.toString().padStart(3, '0')}",
                    color = MaterialTheme.colorScheme.onSecondary,
                    fontWeight = FontWeight.Normal,
                    fontSize = 10.sp,
                    modifier = Modifier
                        .padding(8.dp)
                )

                Text(
                    text = pokemon.name?.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
                        .orEmpty(),
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .padding(8.dp)
                )
            }
        }
    }
}