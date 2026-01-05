package dev.jmoicano.validator

class SetWordValidator(
    private val words: Set<String>
) : WordValidator {

    override fun isValid(word: String): Boolean {
        return words.contains(word.lowercase())
    }
}