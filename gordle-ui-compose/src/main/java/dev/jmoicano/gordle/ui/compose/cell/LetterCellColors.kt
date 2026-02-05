package dev.jmoicano.gordle.ui.compose.cell

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class LetterCellColors(
    val background: Color,
    val content: Color,
    val border: Color
)