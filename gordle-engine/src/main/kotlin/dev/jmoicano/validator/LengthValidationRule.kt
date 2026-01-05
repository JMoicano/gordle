package dev.jmoicano.validator

class LengthValidationRule(
    private val requiredLength: Int,
): GuessValidationRule {
    override fun validate(guess: String): ValidationResult {
        return if (guess.length == requiredLength) {
            ValidationResult.Valid
        } else {
            ValidationResult.Invalid("Word must have $requiredLength letters")
        }
    }
}