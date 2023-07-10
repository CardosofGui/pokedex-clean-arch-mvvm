package cardosofgui.android.pokedexcleanarchmvvm.presentation.pokemonDetails.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import cardosofgui.android.pokedexcleanarchmvvm.domain.entity.Extensions.Companion.getBackgroundColor
import cardosofgui.android.pokedexcleanarchmvvm.domain.entity.Types
import java.util.Locale

/**
 * Composable que exibe um chip para um tipo de Pokémon.
 *
 * @param type O tipo de Pokémon a ser exibido.
 * @param modifier O modificador para personalizar a aparência e o comportamento do chip.
 */
@Composable
fun TypeShip(
    type: Types,
    modifier: Modifier = Modifier
) {
    Text(
        text = type.type.name?.name?.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
            .orEmpty(),
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onBackground,
        modifier = modifier
            .clip(RoundedCornerShape(40.dp))
            .background(type.type.name.getBackgroundColor())
            .padding(horizontal = 12.dp, vertical = 4.dp)
    )
}
