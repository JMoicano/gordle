package dev.jmoicano.rules.evaluation

import dev.jmoicano.model.LetterState
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ClassicWordleEvaluationRuleTest {
    private val rule = ClassicWordleEvaluationRule()

    @Test
    fun `all letters correct`() {
        val result = rule.evaluate("crane", "crane")

        assertTrue(result.all { it.state == LetterState.CORRECT })
    }

    @Test
    fun `letters present and absent`() {
        val result = rule.evaluate("crane", "cigar")

        assertEquals(
            listOf(
                LetterState.CORRECT, // c
                LetterState.PRESENT, // r
                LetterState.PRESENT, // a
                LetterState.ABSENT,  // n
                LetterState.ABSENT, // e
            ),
            result.map { it.state }
        )
    }

    @Test
    fun `repeated letters handled correctly`() {
        val result = rule.evaluate("civic", "cigar")

        assertEquals(
            listOf(
                LetterState.CORRECT, // c
                LetterState.CORRECT, // i
                LetterState.ABSENT,  // v
                LetterState.ABSENT,  // i
                LetterState.ABSENT,  // c
            ),
            result.map { it.state }
        )
    }
}