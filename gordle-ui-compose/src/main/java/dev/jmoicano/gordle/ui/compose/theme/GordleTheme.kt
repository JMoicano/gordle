package dev.jmoicano.gordle.ui.compose.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import dev.jmoicano.gordle.ui.compose.cell.LetterCellColorScheme
import dev.jmoicano.gordle.ui.compose.cell.scheme.ClassicWordleScheme

@Composable
fun GordleTheme(
    letterCellColorScheme: LetterCellColorScheme = ClassicWordleScheme,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        LocalLetterCellColorScheme provides letterCellColorScheme
    ) {
        content()
    }
}