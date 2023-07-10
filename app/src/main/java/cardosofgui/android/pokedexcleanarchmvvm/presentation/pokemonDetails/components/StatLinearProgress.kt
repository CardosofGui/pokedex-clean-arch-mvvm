package cardosofgui.android.pokedexcleanarchmvvm.presentation.pokemonDetails.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

/**
 * Composable que exibe uma barra de progresso linear para uma estatística.
 *
 * @param baseStatFloat O valor da estatística como um número em ponto flutuante.
 * @param modifier O modificador para personalizar a aparência e o comportamento da barra de progresso.
 * @param color A cor da barra de progresso.
 */
@Composable
fun StatLinearProgress(
    baseStatFloat: Float,
    modifier: Modifier = Modifier,
    color: Color,
) {
    var progress by remember { mutableStateOf(0f) }
    val progressAnimDuration = 1500
    val progressAnimation by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(durationMillis = progressAnimDuration, easing = FastOutSlowInEasing)
    )

    LinearProgressIndicator(
        progress = progressAnimation,
        color = color,
        trackColor = color.copy(alpha = 0.4f),
        modifier = modifier.fillMaxWidth()
    )

    LaunchedEffect(baseStatFloat) {
        progress = baseStatFloat
    }
}
