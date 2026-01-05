package dev.jmoicano.model

/**
 * Represents the evaluation result of a single letter.
 *
 * @property letter The guessed letter.
 * @property state The evaluated [LetterState] of the letter.
 */
data class LetterResult(
    val letter: Char,
    val state: LetterState,
)
