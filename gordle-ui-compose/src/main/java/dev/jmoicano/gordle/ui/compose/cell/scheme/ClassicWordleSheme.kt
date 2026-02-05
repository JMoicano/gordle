package dev.jmoicano.gordle.ui.compose.cell.scheme

import androidx.compose.ui.graphics.Color
import dev.jmoicano.gordle.ui.compose.cell.LetterCellColorScheme
import dev.jmoicano.gordle.ui.compose.cell.LetterCellColors
import dev.jmoicano.gordle.ui.compose.cell.LetterState

object ClassicWordleScheme : LetterCellColorScheme {

    override fun colorsFor(state: LetterState): LetterCellColors =
        when (state) {

            LetterState.Empty ->
                LetterCellColors(
                    background = Color.Transparent,
                    content = Color(0xFF1A1A1B),
                    border = Color(0xFF878A8C)
                )

            LetterState.Filled ->
                LetterCellColors(
                    background = Color.Transparent,
                    content = Color(0xFF1A1A1B),
                    border = Color(0xFF565758)
                )

            LetterState.Correct ->
                LetterCellColors(
                    background = Color(0xFF6AAA64),
                    content = Color.White,
                    border = Color(0xFF6AAA64)
                )

            LetterState.Misplaced ->
                LetterCellColors(
                    background = Color(0xFFC9B458),
                    content = Color.White,
                    border = Color(0xFFC9B458)
                )

            LetterState.Wrong ->
                LetterCellColors(
                    background = Color(0xFF787C7E),
                    content = Color.White,
                    border = Color(0xFF787C7E)
                )
        }
}
