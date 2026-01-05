package dev.jmoicano.rules.preset

import dev.jmoicano.rules.evaluation.ClassicWordleEvaluationRule
import dev.jmoicano.validator.SetWordValidator
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ClassicRulesetTest {
    @Test
    fun `classic ruleset provides correct rules`() {
        val ruleset = ClassicRuleset(
            wordLength = 5,
            dictionary = SetWordValidator(setOf("crane"))
        )

        assertTrue(ruleset.evaluationRule is ClassicWordleEvaluationRule)
        assertEquals(2, ruleset.validationRules.size)
    }
}