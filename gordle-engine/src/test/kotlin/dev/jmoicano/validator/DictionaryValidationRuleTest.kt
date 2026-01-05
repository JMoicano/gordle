package dev.jmoicano.validator

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DictionaryValidationRuleTest() {
    private val validator = SetWordValidator(
        setOf("crane", "cigar")
    )

    @Test
    fun `word exists in dictionary`() {
        val rule = DictionaryValidationRule(validator)

        val result = rule.validate("crane")

        assertTrue(result is ValidationResult.Valid)
    }

    @Test
    fun `word does not exist in dictionary`() {
        val rule = DictionaryValidationRule(validator)

        val result = rule.validate("apple")

        assertTrue(result is ValidationResult.Invalid)
    }
}