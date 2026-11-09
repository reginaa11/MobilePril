package com.example.dessertclicker.ui

import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DessertViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(DessertUiState())
    val uiState: StateFlow<DessertUiState> = _uiState.asStateFlow()

    fun onDessertClicked() {
        val currentDessert = Datasource.dessertList[_uiState.value.currentDessertIndex]

        _uiState.update { currentState ->
            val newRevenue = currentState.revenue + currentDessert.price
            val newDessertsSold = currentState.dessertsSold + 1
            var newDessertIndex = currentState.currentDessertIndex

            // Проверяем, не пора ли сменить десерт (если продано достаточно штук)
            val nextDessert = Datasource.dessertList.getOrNull(newDessertIndex + 1)
            if (nextDessert != null && newDessertsSold >= nextDessert.startProductionAmount) {
                newDessertIndex++
            }

            currentState.copy(
                revenue = newRevenue,
                dessertsSold = newDessertsSold,
                currentDessertIndex = newDessertIndex
            )
        }
    }
}