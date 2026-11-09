package com.example.unscramble.data

val testWords: Set<String> = setOf("animal", "assert", "basket", "building", "bus")

fun getUnscrambledWord(scrambledWord: String): String {
    return testWords.firstOrNull { word ->
        word.toCharArray().sorted() == scrambledWord.toCharArray().sorted()
    } ?: ""
}