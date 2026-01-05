package dev.jmoicano.rules

import dev.jmoicano.validator.GuessValidationRule

/**
 * Defines a complete set of rules used by the [dev.jmoicano.engine.GordleEngine].
 *
 * A ruleset encapsulates:
 * - how guesses are validated
 * - how guesses are evaluated
 *
 * This allows multiple game variations without modifying the engine.
 */
interface GordleRuleset {
    val evaluationRule: GuessEvaluationRule
    val validationRules: List<GuessValidationRule>
}