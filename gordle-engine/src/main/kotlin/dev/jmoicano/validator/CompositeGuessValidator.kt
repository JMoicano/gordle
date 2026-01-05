package dev.jmoicano.validator

class CompositeGuessValidator(
    private val rules: List<GuessValidationRule>
) {

    fun validate(guess: String): ValidationResult {
        rules.forEach { rule ->
            val result = rule.validate(guess)
            if (result is ValidationResult.Invalid) {
                return result
            }
        }
        return ValidationResult.Valid
    }
}