package dev.jmoicano.gordle.ui.compose.board

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.jmoicano.gordle.ui.compose.cell.EditableLetterCell
import dev.jmoicano.gordle.ui.compose.cell.LetterState
import dev.jmoicano.gordle.ui.compose.theme.GordleTheme
import kotlin.collections.List

@Immutable
data class BoardCell(
    val value: String,
    val state: LetterState
)

typealias BoardRow = List<BoardCell>

@Composable
fun GordleBoard(
    rows: List<BoardRow>,
    onCellValueChange: (row: Int, column: Int, value: String) -> Unit,
    modifier: Modifier = Modifier,
    cellSize: Dp = 56.dp,
    cellSpacing: Dp = 8.dp,
    enabled: Boolean = true
) {
    val rowCount = rows.size
    val columnCount = rows.firstOrNull()?.size ?: return

    val focusRequesters = remember(rows) {
        List(rowCount) {
            List(columnCount) { FocusRequester() }
        }
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(cellSpacing)
    ) {
        rows.forEachIndexed { rowIndex, row ->
            Row(horizontalArrangement = Arrangement.spacedBy(cellSpacing)) {
                row.forEachIndexed { colIndex, cell ->
                    EditableLetterCell(
                        value = cell.value,
                        state = cell.state,
                        enabled = enabled,
                        modifier = Modifier
                            .size(cellSize)
                            .focusRequester(focusRequesters[rowIndex][colIndex]),
                        onValueChange = { newValue ->
                            onCellValueChange(rowIndex, colIndex, newValue)

                            val nextFocus =
                                if (newValue.isNotEmpty()) colIndex + 1
                                else colIndex - 1

                            focusRequesters[rowIndex]
                                .getOrNull(nextFocus)
                                ?.requestFocus()
                        }
                    )
                }
            }
        }
    }
}

private data class PreviewCell(
    var value: String,
    var state: LetterState
)

@Preview(
    name = "Board – Mixed States & Focus",
    showBackground = true,
    widthDp = 360
)
@Composable
fun BoardPreview_MixedStates_FocusNavigation() {
    GordleTheme {
        val rows = remember {
            mutableStateListOf(
                mutableStateListOf(
                    PreviewCell("C", LetterState.Correct),
                    PreviewCell("A", LetterState.Misplaced),
                    PreviewCell("T", LetterState.Wrong),
                    PreviewCell("S", LetterState.Wrong),
                    PreviewCell("", LetterState.Empty),
                ),
                mutableStateListOf(
                    PreviewCell("", LetterState.Empty),
                    PreviewCell("", LetterState.Empty),
                    PreviewCell("", LetterState.Empty),
                    PreviewCell("", LetterState.Empty),
                    PreviewCell("", LetterState.Empty),
                ),
            )
        }

        val focusRequesters = remember {
            List(rows.size) {
                List(rows[0].size) { FocusRequester() }
            }
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            rows.forEachIndexed { rowIndex, row ->
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    row.forEachIndexed { colIndex, cell ->
                        EditableLetterCell(
                            value = cell.value,
                            state = cell.state,
                            modifier = Modifier
                                .size(56.dp)
                                .focusRequester(focusRequesters[rowIndex][colIndex])
                                .focusable(),
                            onValueChange = { newValue ->
                                cell.value = newValue
                                cell.state =
                                    if (newValue.isEmpty()) LetterState.Empty
                                    else LetterState.Filled

                                if (newValue.isNotEmpty()) {
                                    focusRequesters
                                        .getOrNull(rowIndex)
                                        ?.getOrNull(colIndex + 1)
                                        ?.requestFocus()
                                } else {
                                    focusRequesters
                                        .getOrNull(rowIndex)
                                        ?.getOrNull(colIndex - 1)
                                        ?.requestFocus()
                                }
                            }
                        )
                    }
                }
            }
        }

        LaunchedEffect(Unit) {
            focusRequesters[1][0].requestFocus()
        }
    }
}
