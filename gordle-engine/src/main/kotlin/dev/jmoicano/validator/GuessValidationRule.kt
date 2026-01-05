package dev.jmoicano.validator

/**
 * Defines a validation rule applied to a guess.
 */
interface GuessValidationRule {

    /**
     * Validates a guessed word.
     *
     * @param guess The guessed word.
     * @return A [ValidationResult] indicating whether the guess is valid.
     */
    fun validate(
        guess: String,
    ): ValidationResult
}

/**
 * Represents the result of a guess validation.
 */
sealed class ValidationResult {
    /** Indicates a valid guess. */
    object Valid : ValidationResult()
    /**
     * Indicates an invalid guess.
     *
     * @property reason A human-readable explanation for the failure.
     */
    data class Invalid(val reason: String) : ValidationResult()
}
