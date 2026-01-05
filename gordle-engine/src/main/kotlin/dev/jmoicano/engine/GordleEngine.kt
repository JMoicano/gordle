package dev.jmoicano.engine

import dev.jmoicano.model.GuessResult
import dev.jmoicano.rules.GordleRuleset
import dev.jmoicano.validator.CompositeGuessValidator
import dev.jmoicano.validator.ValidationResult

/**
 * Core engine responsible for validating and evaluating guesses.
 *
 * The engine applies a [GordleRuleset] to:
 * - validate guesses
 * - evaluate letter states
 * - return deterministic results
 *
 * @constructor Creates a new [GordleEngine] using the provided [GordleRuleset].
 */
class GordleEngine(
    private val ruleset: GordleRuleset
) {
    private val validator = CompositeGuessValidator(
        ruleset.validationRules
    )

    /**
     * Evaluates a guess against the correct answer.
     *
     * @param guess The guessed word.
     * @param answer The correct answer word.
     * @return A [GuessResult] containing the evaluation.
     *
     * @throws InvalidWordException If the guess does not pass validation rules.
     */
    fun evaluateGuess(
        guess: String,
        answer: String
    ): GuessResult {

        when(val validation = validator.validate(guess)) {
            is ValidationResult.Invalid ->
                throw InvalidWordException(validation.reason)

            ValidationResult.Valid -> Unit
        }

        val letters = ruleset.evaluationRule.evaluate(guess, answer)

        return GuessResult(
            guess = guess,
            letters = letters,
            isCorrect = guess.equals(answer, ignoreCase = true)
        )
    }
}

class InvalidWordException(word: String) :
    IllegalArgumentException("Invalid word $word")
