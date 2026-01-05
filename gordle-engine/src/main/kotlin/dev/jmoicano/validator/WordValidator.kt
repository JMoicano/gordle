package dev.jmoicano.validator

/**
 * Validates whether a word is allowed to be guessed.
 *
 * Implementations may use in-memory sets, databases, APIs, or other sources.
 */
interface WordValidator {
    /**
     * Checks if the given word is valid.
     *
     * @param word The word to validate.
     * @return True if the word is valid, false otherwise.
     */
    fun isValid(word: String): Boolean
}