package dev.jmoicano.model

/**
 * Represents the result of a guess evaluation.
 *
 * @property guess The original guessed word.
 * @property letters A list of [LetterResult] with the same length as the guess.
 * @property isCorrect Indicates whether the guess exactly matches the answer.
 */
data class GuessResult(
    val guess: String,
    val letters: List<LetterResult>,
    val isCorrect: Boolean,
)
