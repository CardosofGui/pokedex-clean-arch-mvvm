package cardosofgui.android.pokedexcleanarchmvvm.presentation

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat


// DarkTheme
val backgroundDark = Color(0xFFDC0A2D)
val primaryDark = Color(0xFFFFFFFF)
val onPrimaryDark = Color(0xFFFFFFFF)
val secondary = Color(0xFFEFEFEF)
val onSecondary = Color(0xFF666666)

// Others
val white = Color(0xFFFFFFFF)

private val DarkColorScheme = darkColorScheme(
    background = backgroundDark,
    onBackground = white,
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    onSecondary = onSecondary,
    secondary = secondary
)

@Composable
fun PokedexCleanArchMVVMTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = if(darkTheme) DarkColorScheme else DarkColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.background.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        content = content
    )
}