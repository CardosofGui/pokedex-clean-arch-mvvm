package cardosofgui.android.pokedexcleanarchmvvm.presentation.pokemonDetails

import androidx.compose.animation.Crossfade
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.TopCenter
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cardosofgui.android.pokedexcleanarchmvvm.R
import cardosofgui.android.pokedexcleanarchmvvm.application.PokemonDetailsActivity
import cardosofgui.android.pokedexcleanarchmvvm.domain.entity.Extensions.Companion.getBackgroundColor
import cardosofgui.android.pokedexcleanarchmvvm.presentation.pokemonDetails.components.AboutItem
import cardosofgui.android.pokedexcleanarchmvvm.presentation.pokemonDetails.components.FavoriteIcon
import cardosofgui.android.pokedexcleanarchmvvm.presentation.pokemonDetails.components.StatLineWithLabel
import cardosofgui.android.pokedexcleanarchmvvm.presentation.pokemonDetails.components.TypeShip
import coil.compose.SubcomposeAsyncImage
import java.util.Locale

/**
 * Composable que exibe a tela de detalhes de um Pokémon.
 *
 * @param modifier O modificador para personalizar a aparência e o comportamento da tela de detalhes.
 * @param viewModel O ViewModel relacionado à tela de detalhes.
 */
@OptIn(ExperimentalLifecycleComposeApi::class, ExperimentalAnimationApi::class)
@Composable
internal fun PokemonDetailsActivity.PokemonDetailsView(
    modifier: Modifier = Modifier,
    viewModel: PokemonDetailsViewModel
) {
    val pokemonDetails by viewModel.pokemonDetails.collectAsStateWithLifecycle()

    val pokemonId = pokemonDetails?.id
    val name = pokemonDetails?.name
    val favoriteStatus = pokemonDetails?.favoriteStatus ?: false
    val mainTypeColor = pokemonDetails?.types?.first()?.type?.name.getBackgroundColor()

    window.statusBarColor = mainTypeColor.toArgb()

    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .background(mainTypeColor)
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.pokeball),
                contentScale = ContentScale.Fit,
                alpha = if (isSystemInDarkTheme()) 0.15f else 0.15f,
                alignment = TopEnd
            )
    ) {
        Box {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                IconButton(
                    onClick = { finish() },
                    modifier = modifier
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowBack,
                        contentDescription = "Back icon",
                        tint = MaterialTheme.colorScheme.onBackground,
                        modifier = Modifier
                            .size(32.dp)
                    )
                }

                Text(
                    text = name?.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }.orEmpty(),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.weight(1f)
                )

                Text(
                    text = if(pokemonId != null) "#${pokemonId.toString().padStart(3, '0')}" else "Carregando...",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(end = 18.dp)
                )
            }
        }

        Box(modifier = Modifier.fillMaxSize()) {
            SubcomposeAsyncImage(
                model = pokemonDetails?.mainImage,
                contentDescription = "",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(284.dp)
                    .align(TopCenter)
                    .zIndex(1f)
            )


            Box(
                modifier = Modifier
                    .align(BottomCenter)
                    .fillMaxWidth()
                    .fillMaxHeight(0.68f)
                    .padding(4.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.White)
            ) {
                Crossfade(
                    targetState = favoriteStatus,
                    modifier = Modifier
                        .align(TopEnd)

                ) {
                    when(it) {
                        true -> FavoriteIcon(
                            favoriteStatus = true,
                            onClickFavorite = { viewModel.favoritePokemon(false) },
                            modifier = Modifier
                                .padding(18.dp)
                                .size(32.dp)
                        )
                        false -> FavoriteIcon(
                            favoriteStatus = false,
                            onClickFavorite = { viewModel.favoritePokemon(true) },
                            modifier = Modifier
                                .padding(18.dp)
                                .size(32.dp)
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .padding(top = 64.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        pokemonDetails?.types?.forEach { type ->
                            TypeShip(
                                type = type,
                                modifier = Modifier
                                    .padding(horizontal = 6.dp)
                            )
                        }
                    }

                    Text(
                        text = "Sobre",
                        fontSize = 24.sp,
                        color = mainTypeColor,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(CenterHorizontally)
                            .padding(top = 12.dp)
                    )

                    Row {
                        AboutItem(
                            label = "Altura",
                            value = "${pokemonDetails?.height ?: 0.0} m",
                            icon = ImageVector.vectorResource(id = R.drawable.height),
                            modifier = Modifier
                                .padding(12.dp)
                                .weight(1f)
                        )

                        AboutItem(
                            label = "Peso",
                            value = "${pokemonDetails?.weight ?: 0.0} kg",
                            icon = ImageVector.vectorResource(id = R.drawable.weight),
                            modifier = Modifier
                                .padding(12.dp)
                                .weight(1f)
                        )
                    }

                    Text(
                        text = "Status Base",
                        fontSize = 24.sp,
                        color = mainTypeColor,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .align(CenterHorizontally)
                            .padding(vertical = 12.dp)
                    )


                    Column {
                        pokemonDetails?.stats?.forEach { stat ->
                            StatLineWithLabel(
                                stat = stat,
                                color = mainTypeColor,
                                modifier = Modifier.padding(horizontal = 12.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}