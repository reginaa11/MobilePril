package com.example.unscramble.ui

import com.example.unscramble.data.SCORE_INCREASE
import com.example.unscramble.data.getUnscrambledWord
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class GameViewModelTest {
    private val viewModel = GameViewModel()

    @Test
    fun gameViewModel_IncorrectGuess_ErrorFlagSet() {
        val currentGameUiState = viewModel.uiState.value
        val incorrectPlayerWord = "qwerty"

        viewModel.updateUserGuess(incorrectPlayerWord)
        viewModel.checkUserGuess()

        val updatedGameUiState = viewModel.uiState.value
        assertTrue(updatedGameUiState.isGuessedWordWrong)
        assertEquals(0, updatedGameUiState.score)
        assertEquals(1, updatedGameUiState.currentWordCount)
    }

    @Test
    fun gameViewModel_Initialization_FirstWordLoaded() {
        val gameUiState = viewModel.uiState.value
        val unscrambledWord = getUnscrambledWord(gameUiState.currentScrambledWord)

        assertTrue(unscrambledWord.isNotEmpty())
        assertEquals(1, gameUiState.currentWordCount)
        assertEquals(0, gameUiState.score)
        assertFalse(gameUiState.isGuessedWordWrong)
    }

    @Test
    fun gameViewModel_AllWordsGuessed_UiStateUpdatedCorrectly() {
        var expectedScore = 0
        var currentGameUiState = viewModel.uiState.value

        while (currentGameUiState.currentWordCount < 10) {
            val correctPlayerWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)
            viewModel.updateUserGuess(correctPlayerWord)
            viewModel.checkUserGuess()

            expectedScore += SCORE_INCREASE
            currentGameUiState = viewModel.uiState.value
        }

        val lastCorrectWord = getUnscrambledWord(currentGameUiState.currentScrambledWord)
        viewModel.updateUserGuess(lastCorrectWord)
        viewModel.checkUserGuess()

        val finalGameUiState = viewModel.uiState.value
        assertTrue(finalGameUiState.isGameOver)
        assertEquals(expectedScore + SCORE_INCREASE, finalGameUiState.score)
    }

    @Test
    fun gameViewModel_WordSkipped_ScoreUnchangedAndWordCountIncreased() {
        var currentGameUiState = viewModel.uiState.value
        val originalScore = currentGameUiState.score
        val originalWordCount = currentGameUiState.currentWordCount

        viewModel.skipWord()

        currentGameUiState = viewModel.uiState.value
        assertEquals(originalScore, currentGameUiState.score)
        assertEquals(originalWordCount + 1, currentGameUiState.currentWordCount)
    }
}