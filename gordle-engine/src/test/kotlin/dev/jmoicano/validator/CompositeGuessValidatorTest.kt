package dev.jmoicano.validator

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CompositeGuessValidatorTest {

    @Test
    fun `all rules valid`() {
        val validator = CompositeGuessValidator(
            listOf(
                LengthValidationRule(5),
                DictionaryValidationRule(
                    SetWordValidator(setOf("crane"))
                )
            )
        )

        val result = validator.validate("crane")

        assertTrue(result is ValidationResult.Valid)
    }

    @Test
    fun `first invalid rule stops validation`() {
        val validator = CompositeGuessValidator(
            listOf(
                LengthValidationRule(5),
                DictionaryValidationRule(
                    SetWordValidator(setOf("crane"))
                )
            )
        )

        val result = validator.validate("cat")

        assertTrue(result is ValidationResult.Invalid)
    }
}