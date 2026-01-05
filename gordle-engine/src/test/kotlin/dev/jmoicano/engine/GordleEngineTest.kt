package dev.jmoicano.engine

import dev.jmoicano.rules.preset.ClassicRuleset
import dev.jmoicano.validator.SetWordValidator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class GordleEngineTest {
    private val dictionary =
        SetWordValidator(setOf("crane", "cigar", "civic"))

    private val engine = GordleEngine(
        ClassicRuleset(
            wordLength = 5,
            dictionary = dictionary
        )
    )

    @Test
    fun `valid guess returns result`() {
        val result = engine.evaluateGuess(
            guess = "crane",
            answer = "cigar"
        )

        assertEquals("crane", result.guess)
        assertFalse(result.isCorrect)
        assertEquals(5, result.letters.size)
    }

    @Test
    fun `correct guess sets isCorrect true`() {
        val result = engine.evaluateGuess(
            guess = "crane",
            answer = "crane"
        )

        assertTrue(result.isCorrect)
    }

    @Test
    fun `invalid word throws exception`() {
        assertThrows(InvalidWordException::class.java) {
            engine.evaluateGuess(
                guess = "apple",
                answer = "crane",
            )
        }
    }
}