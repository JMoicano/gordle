package dev.jmoicano.gordle.ui.compose.cell

interface LetterCellColorScheme {
    fun colorsFor(state: LetterState): LetterCellColors
}