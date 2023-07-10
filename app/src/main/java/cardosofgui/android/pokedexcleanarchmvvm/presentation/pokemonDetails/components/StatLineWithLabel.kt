package cardosofgui.android.pokedexcleanarchmvvm.presentation.pokemonDetails.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cardosofgui.android.pokedexcleanarchmvvm.domain.entity.Stats
import java.util.Locale

/**
 * Composable que exibe uma linha de estatística com rótulo, barra de progresso e valor.
 *
 * @param stat A estatística a ser exibida.
 * @param modifier O modificador para personalizar a aparência e o comportamento da linha de estatística.
 * @param color A cor a ser aplicada ao rótulo e à barra de progresso.
 */
@Composable
fun StatLineWithLabel(
    stat: Stats,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colorScheme.primary
) {
    val name = stat.stat?.name.orEmpty().replaceFirstChar { if (it.isLowerCase()) it.titlecase(
        Locale.ROOT) else it.toString() }
    val baseStat = stat.baseStat.toString()

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = name,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = color
        )

        StatLinearProgress(
            baseStatFloat = stat.calculateProgress(),
            color = color,
            modifier = Modifier
                .padding(vertical = 6.dp)
                .height(14.dp)
                .weight(1f)
                .padding(horizontal = 6.dp)
                .clip(CircleShape)
        )

        Text(
            text = baseStat.padStart(3, '0'),
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = Color.Black
        )
    }
}

/**
 * Calcula o progresso da estatística para exibição na barra de progresso.
 *
 * @return O valor de progresso calculado.
 */
private fun Stats?.calculateProgress(): Float {
    if (this == null) return 0f
    val baseStat = this.baseStat?.toFloat() ?: return 0f
    val result = baseStat * 100f / 255f / 100f
    return result
}
