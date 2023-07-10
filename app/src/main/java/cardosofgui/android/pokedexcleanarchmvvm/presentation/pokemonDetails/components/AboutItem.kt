package cardosofgui.android.pokedexcleanarchmvvm.presentation.pokemonDetails.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Composable que exibe um item de informações no formato "label: value" com um ícone.
 *
 * @param label O rótulo do item.
 * @param value O valor do item.
 * @param icon O ícone a ser exibido.
 * @param modifier O modificador para personalizar a aparência e o comportamento do item.
 */
@Composable
fun AboutItem(
    label: String,
    value: String,
    icon: ImageVector,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = icon,
                contentDescription = "$label icon",
                tint = Color.Black,
                modifier = Modifier
                    .size(16.dp)
                    .padding(end = 4.dp)
            )

            Text(
                text = value,
                fontSize = 14.sp,
                color = Color.Black
            )
        }

        Text(
            text = label,
            fontSize = 12.sp,
            modifier = Modifier
                .align(CenterHorizontally)
        )
    }
}
