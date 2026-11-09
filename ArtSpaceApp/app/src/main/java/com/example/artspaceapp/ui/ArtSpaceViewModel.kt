package com.example.artspaceapp.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ArtSpaceViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(ArtSpaceUiState())
    val uiState: StateFlow<ArtSpaceUiState> = _uiState.asStateFlow()

    fun nextArtwork(maxSize: Int) {
        _uiState.update { currentState ->
            if (currentState.currentArtworkIndex < maxSize - 1) {
                currentState.copy(currentArtworkIndex = currentState.currentArtworkIndex + 1)
            } else {
                currentState
            }
        }
    }

    fun previousArtwork() {
        _uiState.update { currentState ->
            if (currentState.currentArtworkIndex > 0) {
                currentState.copy(currentArtworkIndex = currentState.currentArtworkIndex - 1)
            } else {
                currentState
            }
        }
    }
}