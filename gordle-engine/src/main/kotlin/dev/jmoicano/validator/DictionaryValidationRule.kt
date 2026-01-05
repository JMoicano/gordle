package dev.jmoicano.validator

class DictionaryValidationRule(
    private val validator: WordValidator
): GuessValidationRule {
    override fun validate(guess: String): ValidationResult {
        return if (validator.isValid(guess)) {
            ValidationResult.Valid
        } else {
            ValidationResult.Invalid("Word $guess not found in dictionary")
        }
    }
}