package com.example.unscramble

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.unscramble.ui.GameViewModel
import com.example.unscramble.ui.theme.UnscrambleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UnscrambleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GameScreen()
                }
            }
        }
    }
}

@Composable
fun GameScreen(gameViewModel: GameViewModel = viewModel()) {
    val gameUiState by gameViewModel.uiState.collectAsState()
    var userGuess by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Text(text = "Счет: ${gameUiState.score}", fontSize = 20.sp)
        Text(text = "Слово: ${gameUiState.currentWordCount} из 10", fontSize = 16.sp)

        Text(
            text = gameUiState.currentScrambledWord,
            fontSize = 45.sp,
            textAlign = TextAlign.Center
        )

        OutlinedTextField(
            value = userGuess,
            onValueChange = {
                userGuess = it
                gameViewModel.updateUserGuess(it)
            },
            label = {
                if (gameUiState.isGuessedWordWrong) {
                    Text("Неверно!")
                } else {
                    Text("Введите слово")
                }
            },
            isError = gameUiState.isGuessedWordWrong,
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { gameViewModel.checkUserGuess() })
        )

        Button(
            onClick = { gameViewModel.checkUserGuess() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Отправить")
        }

        OutlinedButton(
            onClick = { gameViewModel.skipWord() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Пропустить")
        }

        if (gameUiState.isGameOver) {
            AlertDialog(
                onDismissRequest = { },
                title = { Text("Игра окончена!") },
                text = { Text("Ваш счет: ${gameUiState.score}") },
                confirmButton = {
                    Button(onClick = { gameViewModel.resetGame() }) {
                        Text("Играть снова")
                    }
                }
            )
        }
    }
}