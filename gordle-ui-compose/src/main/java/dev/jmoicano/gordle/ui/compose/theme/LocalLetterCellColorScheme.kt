package dev.jmoicano.gordle.ui.compose.theme

import androidx.compose.runtime.staticCompositionLocalOf
import dev.jmoicano.gordle.ui.compose.cell.LetterCellColorScheme
import dev.jmoicano.gordle.ui.compose.cell.scheme.ClassicWordleScheme

val LocalLetterCellColorScheme = staticCompositionLocalOf<LetterCellColorScheme> {
    ClassicWordleScheme
}