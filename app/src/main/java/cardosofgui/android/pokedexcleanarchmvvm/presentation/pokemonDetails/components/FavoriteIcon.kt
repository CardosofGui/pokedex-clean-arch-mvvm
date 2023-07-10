package cardosofgui.android.pokedexcleanarchmvvm.presentation.pokemonDetails.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * Composable que exibe um ícone de favorito.
 *
 * @param favoriteStatus O status de favorito.
 * @param onClickFavorite O callback para ser chamado quando o ícone de favorito for clicado.
 * @param modifier O modificador para personalizar a aparência e o comportamento do ícone.
 */
@Composable
fun FavoriteIcon(
    favoriteStatus: Boolean,
    onClickFavorite: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClickFavorite,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (favoriteStatus) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder,
            contentDescription = "Favorite Icon",
            tint = Color.Red
        )
    }
}
