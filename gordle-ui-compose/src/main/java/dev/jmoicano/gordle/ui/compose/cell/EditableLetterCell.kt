package dev.jmoicano.gordle.ui.compose.cell

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.jmoicano.gordle.ui.compose.theme.GordleTheme
import dev.jmoicano.gordle.ui.compose.theme.LocalLetterCellColorScheme

@Composable
fun EditableLetterCell(
    value: String,
    onValueChange: (String) -> Unit,
    state: LetterState,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTextStyle.current,
    colorScheme: LetterCellColorScheme = LocalLetterCellColorScheme.current,
    shape: Shape = RectangleShape,
    enabled: Boolean = true,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    val colors = colorScheme.colorsFor(state)

    val canEdit = enabled && when (state) {
        LetterState.Empty,
        LetterState.Filled -> true
        LetterState.Correct,
        LetterState.Misplaced,
        LetterState.Wrong -> false
    }

    BasicTextField(
        value = value,
        onValueChange = { newValue ->
            if (canEdit) {
                onValueChange(
                    newValue
                        .take(1)
                        .uppercase()
                )
            }
        },
        enabled = enabled,
        readOnly = !canEdit,
        singleLine = true,
        textStyle = textStyle.copy(
            color = colors.content,
            textAlign = TextAlign.Center,
        ),
        interactionSource = interactionSource,
        cursorBrush = if (canEdit) {
            SolidColor(colors.content)
        } else {
            SolidColor(Color.Transparent)
        },
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Characters,
            keyboardType = KeyboardType.Ascii
        ),
        decorationBox = { innerTextField ->
            Box(
                modifier = modifier
                    .background(
                        color = colors.background,
                        shape = shape
                    )
                    .border(
                        width = 1.dp,
                        color = colors.border,
                        shape = shape
                    ),
                contentAlignment = Alignment.Center
            ) {
                innerTextField()
            }
        }
    )
}

@Preview(
    name = "EditableLetterCell – Empty",
    showBackground = true
)
@Composable
private fun EditableLetterCellPreview_Empty() {
    GordleTheme {
        var value by remember { mutableStateOf("") }

        EditableLetterCell(
            value = value,
            state = LetterState.Empty,
            onValueChange = { value = it },
            modifier = Modifier.size(56.dp)
        )
    }
}

@Preview(
    name = "EditableLetterCell – Filled",
    showBackground = true
)
@Composable
private fun EditableLetterCellPreview_Filled() {
    GordleTheme {
        var value by remember { mutableStateOf("A") }

        EditableLetterCell(
            value = value,
            state = LetterState.Filled,
            onValueChange = { value = it },
            modifier = Modifier.size(56.dp)
        )
    }
}

@Preview(
    name = "EditableLetterCell – Correct",
    showBackground = true
)
@Composable
private fun EditableLetterCellPreview_Correct() {
    GordleTheme {
        EditableLetterCell(
            value = "R",
            state = LetterState.Correct,
            onValueChange = {},
            modifier = Modifier.size(56.dp)
        )
    }
}

@Preview(
    name = "EditableLetterCell – Misplaced",
    showBackground = true
)
@Composable
private fun EditableLetterCellPreview_Misplaced() {
    GordleTheme {
        EditableLetterCell(
            value = "O",
            state = LetterState.Misplaced,
            onValueChange = {},
            modifier = Modifier.size(56.dp)
        )
    }
}

@Preview(
    name = "EditableLetterCell – Wrong",
    showBackground = true
)
@Composable
private fun EditableLetterCellPreview_Wrong() {
    GordleTheme {
        EditableLetterCell(
            value = "X",
            state = LetterState.Wrong,
            onValueChange = {},
            modifier = Modifier.size(56.dp)
        )
    }
}

@Preview(
    name = "EditableLetterCell – Disabled",
    showBackground = true
)
@Composable
private fun EditableLetterCellPreview_Disabled() {
    GordleTheme {
        EditableLetterCell(
            value = "",
            state = LetterState.Empty,
            enabled = false,
            onValueChange = {},
            modifier = Modifier.size(56.dp)
        )
    }
}

