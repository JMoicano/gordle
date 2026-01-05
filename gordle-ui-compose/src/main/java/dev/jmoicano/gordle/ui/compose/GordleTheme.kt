package dev.jmoicano.gordle.ui.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import dev.jmoicano.gordle.ui.compose.theme.GordleColors

val LocalGordleColors = staticCompositionLocalOf<GordleColors> {
    error("GordleColors not provided")
}

@Composable
fun GordleTheme(
    colors: GordleColors,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalGordleColors provides colors,
        content = content
    )
}