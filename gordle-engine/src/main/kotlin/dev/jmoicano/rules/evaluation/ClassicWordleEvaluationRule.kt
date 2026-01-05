package dev.jmoicano.rules.evaluation

import dev.jmoicano.model.LetterResult
import dev.jmoicano.model.LetterState
import dev.jmoicano.rules.GuessEvaluationRule
import java.util.Locale

/**
 * Classic Wordle-compatible evaluation rule.
 *
 * - Case-insensitive
 * - Correctly handles repeated letters
 * - Deterministic and side effect free
 */
class ClassicWordleEvaluationRule: GuessEvaluationRule {
    override fun evaluate(
        guess: String,
        answer: String
    ): List<LetterResult> {
        val normalizedGuess = guess.lowercase(Locale.getDefault())
        val normalizedAnswer = answer.lowercase(Locale.getDefault())

        val result = MutableList<LetterResult>(normalizedGuess.length) { index ->
            LetterResult(
                letter = normalizedGuess[index],
                state = LetterState.ABSENT,
            )
        }

        val remainingLetters = mutableMapOf<Char, Int>()

        normalizedAnswer.forEach { char ->
            remainingLetters[char] = remainingLetters.getOrDefault(char, 0) + 1
        }

        // CORRECT VERIFICATION
        for (i in normalizedGuess.indices) {
            val guessLetter = normalizedGuess[i]
            val answerLetter = normalizedAnswer[i]

            if (guessLetter == answerLetter) {
                result[i] = LetterResult(
                    letter = guessLetter,
                    state = LetterState.CORRECT,
                )
                remainingLetters[guessLetter] =
                    remainingLetters.getValue(guessLetter) - 1
            }
        }

        // PRESENT VERIFICATION
        for (i in normalizedGuess.indices) {
            if (result[i].state != LetterState.ABSENT) continue

            val guessLetter = normalizedGuess[i]
            val remaining = remainingLetters.getOrDefault(guessLetter, 0)

            if (remaining > 0) {
                result[i] = LetterResult(
                    letter = guessLetter,
                    state = LetterState.PRESENT,
                )
                remainingLetters[guessLetter] = remaining - 1
            }
        }

        return result
    }
}