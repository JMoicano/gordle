package dev.jmoicano.gordle.ui.compose.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.jmoicano.gordle.ui.compose.GordleTheme
import dev.jmoicano.gordle.ui.compose.LocalGordleColors
import dev.jmoicano.gordle.ui.compose.state.UiLetterState
import dev.jmoicano.gordle.ui.compose.theme.GordleColors

@Composable
fun LetterCell(
    letter: Char?,
    state: UiLetterState,
    modifier: Modifier = Modifier
) {
    val colors = LocalGordleColors.current

    val background = when (state) {
        UiLetterState.EMPTY -> colors.empty
        UiLetterState.FILLED -> colors.filled
        UiLetterState.CORRECT -> colors.correct
        UiLetterState.PRESENT -> colors.present
        UiLetterState.ABSENT -> colors.absent
    }

    Box(
        modifier = modifier
            .size(48.dp)
            .background(background)
            .border(1.dp, Color.Gray),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = letter?.uppercase() ?: "",
            fontSize = 20.sp,
        )
    }
}

@Preview
@Composable
private fun LetterCellPreview() {
    GordleTheme(
        colors = GordleColors(
            empty = Color.Transparent,
            filled = Color.LightGray,
            correct = Color(0xFF6AAA64),
            present = Color(0xFFC9B458),
            absent = Color(0xFF787C7E)
        )
    ) {
        LetterCell(letter = 'A', state = UiLetterState.CORRECT)
    }
}