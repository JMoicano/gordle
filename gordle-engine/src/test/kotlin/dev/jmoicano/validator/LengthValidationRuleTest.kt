package dev.jmoicano.validator

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LengthValidationRuleTest {
    @Test
    fun `valid length`() {
        val rule = LengthValidationRule(5)

        val result = rule.validate("crane")

        assertTrue(result is ValidationResult.Valid)
    }

    @Test
    fun `invalid length`() {
        val rule = LengthValidationRule(5)

        val result = rule.validate("cat")

        assertTrue(result is ValidationResult.Invalid)
    }
}