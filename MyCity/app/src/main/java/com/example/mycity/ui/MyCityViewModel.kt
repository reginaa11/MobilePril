package com.example.mycity.ui

import androidx.lifecycle.ViewModel
import com.example.mycity.model.Category
import com.example.mycity.model.Place
import com.example.mycity.data.DataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MyCityViewModel : ViewModel() {
    private val _selectedCategory = MutableStateFlow(Category.Restaurants)
    val selectedCategory: StateFlow<Category> = _selectedCategory.asStateFlow()

    private val _selectedPlace = MutableStateFlow<Place?>(null)
    val selectedPlace: StateFlow<Place?> = _selectedPlace.asStateFlow()

    fun selectCategory(category: Category) {
        _selectedCategory.value = category
        _selectedPlace.value = null
    }

    fun selectPlace(place: Place) {
        _selectedPlace.value = place
    }

    fun getPlacesForCategory(category: Category): List<Place> {
        return DataSource.places[category] ?: emptyList()
    }
}