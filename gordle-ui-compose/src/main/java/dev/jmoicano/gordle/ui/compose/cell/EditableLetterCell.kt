package dev.jmoicano.gordle.ui.compose.cell

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import dev.jmoicano.gordle.ui.compose.theme.LocalLetterCellColorScheme

@Composable
fun EditableLetterCell(
    value: Char?,
    state: LetterState,
    onValueChange: (Char?) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    requestFocus: Boolean = false,
    onFocusChanged: ((Boolean) -> Unit)? = null,
    textStyle: TextStyle = LocalTextStyle.current,
    colorScheme: LetterCellColorScheme = LocalLetterCellColorScheme.current,
    shape: Shape = RectangleShape
) {
    val focusRequester = remember { FocusRequester() }

    LaunchedEffect(requestFocus) {
        if (requestFocus) {
            focusRequester.requestFocus()
        }
    }

    BasicTextField(
        value = value?.toString().orEmpty(),
        onValueChange = { text ->
            onValueChange(text.lastOrNull()?.uppercaseChar())
        },
        enabled = enabled,
        singleLine = true,
        textStyle = textStyle,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Ascii,
            capitalization = KeyboardCapitalization.Characters,
            imeAction = ImeAction.Next
        ),
        modifier = modifier
            .focusRequester(focusRequester)
            .onFocusChanged { state ->
                onFocusChanged?.invoke(state.isFocused)
            }
    ) { innerTextField ->

        Box(modifier = Modifier.fillMaxSize()) {

            LetterCell(
                letter = value,
                state = state,
                modifier = Modifier.fillMaxSize(),
                textStyle = textStyle,
                colorScheme = colorScheme,
                shape = shape
            )

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                innerTextField()
            }
        }
    }
}
