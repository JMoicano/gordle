package dev.jmoicano.rules.preset

import dev.jmoicano.rules.evaluation.ClassicWordleEvaluationRule
import dev.jmoicano.rules.GordleRuleset
import dev.jmoicano.rules.GuessEvaluationRule
import dev.jmoicano.validator.DictionaryValidationRule
import dev.jmoicano.validator.GuessValidationRule
import dev.jmoicano.validator.LengthValidationRule
import dev.jmoicano.validator.WordValidator

/**
 * Default Wordle-compatible ruleset.
 *
 * Applies:
 * - fixed word length validation
 * - dictionary-based validation
 * - classic Wordle letter evaluation rules
 *
 * @param wordLength Required length of the guessed words.
 * @param dictionary Validator used to check if a word exists.
 */
class ClassicRuleset(
    wordLength: Int,
    dictionary: WordValidator,
): GordleRuleset {
    override val evaluationRule: GuessEvaluationRule = ClassicWordleEvaluationRule()
    override val validationRules: List<GuessValidationRule> =
        listOf(
            LengthValidationRule(wordLength),
            DictionaryValidationRule(dictionary),
        )
}