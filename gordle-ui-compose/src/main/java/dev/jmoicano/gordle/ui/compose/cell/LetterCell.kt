package dev.jmoicano.gordle.ui.compose.cell

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.jmoicano.gordle.ui.compose.cell.scheme.ClassicWordleScheme

@Composable
fun LetterCell(
    letter: Char?,
    state: LetterState,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTextStyle.current,
    colorScheme: LetterCellColorScheme = ClassicWordleScheme,
    shape: Shape = RectangleShape,
    borderWidth: Dp = 1.dp,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    animateStateChange: Boolean = false
) {
    val colors = colorScheme.colorsFor(state)

    val backgroundColor = if (animateStateChange) {
        animateColorAsState(
            targetValue = colors.background,
            label = "LetterCellBackground"
        ).value
    } else {
        colors.background
    }

    Box(
        modifier = modifier
            .background(backgroundColor, shape)
            .border(borderWidth, colors.border, shape)
            .padding(contentPadding),
        contentAlignment = Alignment.Center
    ) {
        if (letter != null) {
            Text(
                text = letter.uppercaseChar().toString(),
                style = textStyle,
                color = colors.content,
                maxLines = 1
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LetterCellPreview() {

    Row(
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        LetterState.entries.forEach { state ->
            LetterCell(
                letter = if (state == LetterState.Empty) null else 'A',
                state = state,
                modifier = Modifier.size(48.dp),
                textStyle = MaterialTheme.typography.titleLarge,
                shape = RoundedCornerShape(4.dp)
            )
        }
    }
}
