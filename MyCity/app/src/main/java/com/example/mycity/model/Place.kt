package com.example.mycity.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.mycity.R

data class Place(
    @StringRes val name: Int,
    @StringRes val description: Int,
    @DrawableRes val imageRes: Int
)

enum class Category(@StringRes val title: Int) {
    Restaurants(R.string.category_restaurants),
    Parks(R.string.category_parks),
    CoffeeShops(R.string.category_coffee),
    Cinemas(R.string.category_cinemas),
    Malls(R.string.category_malls)
}