package dev.jmoicano.rules

import dev.jmoicano.model.LetterResult

/**
 * Defines how a guess is evaluated against the answer.
 */
interface GuessEvaluationRule {

    /**
     * Evaluates a guess against the answer.
     *
     * @param guess The guessed word.
     * @param answer The correct answer word.
     * @return A list of [LetterResult] representing letter evaluations.
     */
    fun evaluate(
        guess: String,
        answer: String,
    ): List<LetterResult>
}