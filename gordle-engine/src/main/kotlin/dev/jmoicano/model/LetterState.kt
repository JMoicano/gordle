package dev.jmoicano.model

/**
 * Represents the evaluation state of a letter in a guess.
 *
 * Each letter can be evaluated as:
 * - [CORRECT]: the letter is correct and in the correct position.
 * - [PRESENT]: the letter exists in the answer but is in a different position.
 * - [ABSENT]: the letter does not exist in the answer.
 */
enum class LetterState {
    CORRECT,
    PRESENT,
    ABSENT,
}