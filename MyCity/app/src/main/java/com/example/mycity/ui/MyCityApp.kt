package com.example.mycity.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mycity.model.Category

@Composable
fun MyCityApp(
    navController: NavHostController = rememberNavController(),
    viewModel: MyCityViewModel = viewModel()
) {
    NavHost(navController = navController, startDestination = "categories") {
        composable("categories") {
            CategoryScreen(
                viewModel = viewModel,
                onCategoryClick = { category ->
                    viewModel.selectCategory(category)
                    navController.navigate("places/${category.name}")
                }
            )
        }
        composable("places/{category}") { backStackEntry ->
            val categoryName = backStackEntry.arguments?.getString("category")
            val category = Category.valueOf(categoryName ?: Category.Restaurants.name)
            PlaceListScreen(
                category = category,
                viewModel = viewModel,
                onPlaceClick = { place ->
                    viewModel.selectPlace(place)
                    navController.navigate("details")
                },
                onBack = { navController.popBackStack() }
            )
        }
        composable("details") {
            PlaceDetailScreen(
                viewModel = viewModel,
                onBack = { navController.popBackStack() }
            )
        }
    }
}

@Composable
fun CategoryScreen(
    viewModel: MyCityViewModel,
    onCategoryClick: (Category) -> Unit
) {
    LazyColumn(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        items(Category.values()) { category ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { onCategoryClick(category) }
            ) {
                Text(
                    text = stringResource(category.title),
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}

@Composable
fun PlaceListScreen(
    category: Category,
    viewModel: MyCityViewModel,
    onPlaceClick: (com.example.mycity.model.Place) -> Unit,
    onBack: () -> Unit
) {
    val places = viewModel.getPlacesForCategory(category)
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = stringResource(category.title),
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.headlineMedium
        )
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(places) { place ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable { onPlaceClick(place) }
                ) {
                    Text(
                        text = stringResource(place.name),
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text("Back")
        }
    }
}

@Composable
fun PlaceDetailScreen(
    viewModel: MyCityViewModel,
    onBack: () -> Unit
) {
    val place by viewModel.selectedPlace.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        place?.let {
            Text(
                text = stringResource(it.name),
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = stringResource(it.description),
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Back")
        }
    }
}