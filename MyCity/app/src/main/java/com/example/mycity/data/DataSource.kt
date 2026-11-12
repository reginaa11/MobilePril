package com.example.mycity.data

import com.example.mycity.R
import com.example.mycity.model.Category
import com.example.mycity.model.Place

object DataSource {
    val places = mapOf(
        Category.Restaurants to listOf(
            Place(R.string.place_restaurant_1, R.string.desc_restaurant_1, R.drawable.ic_launcher_background),
            Place(R.string.place_restaurant_2, R.string.desc_restaurant_2, R.drawable.ic_launcher_background),
            Place(R.string.place_restaurant_3, R.string.desc_restaurant_3, R.drawable.ic_launcher_background)
        ),
        Category.Parks to listOf(
            Place(R.string.place_park_1, R.string.desc_park_1, R.drawable.ic_launcher_background),
            Place(R.string.place_park_2, R.string.desc_park_2, R.drawable.ic_launcher_background),
            Place(R.string.place_park_3, R.string.desc_park_3, R.drawable.ic_launcher_background)
        ),
        Category.CoffeeShops to listOf(
            Place(R.string.place_coffee_1, R.string.desc_coffee_1, R.drawable.ic_launcher_background),
            Place(R.string.place_coffee_2, R.string.desc_coffee_2, R.drawable.ic_launcher_background),
            Place(R.string.place_coffee_3, R.string.desc_coffee_3, R.drawable.ic_launcher_background)
        ),
        Category.Cinemas to listOf(
            Place(R.string.place_cinema_1, R.string.desc_cinema_1, R.drawable.ic_launcher_background),
            Place(R.string.place_cinema_2, R.string.desc_cinema_2, R.drawable.ic_launcher_background),
            Place(R.string.place_cinema_3, R.string.desc_cinema_3, R.drawable.ic_launcher_background)
        ),
        Category.Malls to listOf(
            Place(R.string.place_mall_1, R.string.desc_mall_1, R.drawable.ic_launcher_background),
            Place(R.string.place_mall_2, R.string.desc_mall_2, R.drawable.ic_launcher_background),
            Place(R.string.place_mall_3, R.string.desc_mall_3, R.drawable.ic_launcher_background)
        )
    )
}